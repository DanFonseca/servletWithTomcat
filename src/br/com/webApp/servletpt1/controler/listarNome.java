package br.com.webApp.servletpt1.controler;

import br.com.webApp.servletpt1.modelo.BD;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class listarNome extends HttpServlet implements Acao {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        BD bd = new BD ();
        req.setAttribute("listNomes",  bd.getListNomes());
        return "forward:listarNome.jsp";
    }

}
