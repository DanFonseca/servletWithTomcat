package br.com.webApp.servletpt1.controler.Filter;
import br.com.webApp.servletpt1.controler.Acao;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/controle")
public class controleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //casts
        HttpServletRequest req = (HttpServletRequest)  servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String param = req.getParameter("function");
        String endereco = "";

        try {
            Class cl = Class.forName("br.com.webApp.servletpt1.controler." + param);
            Acao acao = (Acao) cl.newInstance();
            endereco =  acao.executa(req, resp);
        }catch (Throwable e){
            System.out.println(e);
        }

        String enderecoSplit [] = endereco.split(":");

        if(enderecoSplit[0].equals("forward")){
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/" + enderecoSplit[1]);
            rd.forward(req, resp);
        }else if (enderecoSplit[0].equals("redirect")){
            resp.sendRedirect(enderecoSplit[1]);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
