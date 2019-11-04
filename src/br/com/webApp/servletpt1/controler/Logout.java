package br.com.webApp.servletpt1.controler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet implements Acao {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.getSession().invalidate();
        return "redirect:controle?function=LoginForm";
    }
}
