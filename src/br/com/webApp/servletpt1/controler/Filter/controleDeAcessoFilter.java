package br.com.webApp.servletpt1.controler.Filter;
import br.com.webApp.servletpt1.controler.Acao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/controle")
public class controleDeAcessoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain Chain) throws IOException, ServletException {
        System.out.println("iniciando o Filter: controledeAcesso");
        //casts
        HttpServletRequest req = (HttpServletRequest)  servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //end casts

        String param = servletRequest.getParameter("function");
        HttpSession sessao = req.getSession();

        boolean usuarioLogado = (sessao.getAttribute("usuarioLogado") == null);
        boolean pasginaProtegida = !(param.equals("Login") | param.equals("LoginForm"));

        if (usuarioLogado & pasginaProtegida){
            resp.sendRedirect("controle?function=LoginForm");
            return;
        }

        //passa a request para frente depois da validacao
        Chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
