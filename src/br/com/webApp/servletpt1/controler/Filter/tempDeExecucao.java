package br.com.webApp.servletpt1.controler.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/controle")
public class tempDeExecucao implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain Chain) throws IOException, ServletException {
        System.out.println("iniciando o Filter: TempoDeExecucao");
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String param  = req.getParameter("function");

        long tempoInicial = System.currentTimeMillis();
        Chain.doFilter(servletRequest, servletResponse);
        long tempofinal = System.currentTimeMillis();

        System.out.println("tempo de execucao do >> " + param + " " + (tempofinal - tempoInicial));


    }




    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
