package br.com.webApp.servletpt1.controler;

import br.com.webApp.servletpt1.modelo.BD;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deletarNome extends HttpServlet implements Acao{

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
        BD bd = new BD ();
        int index =  bd.getIndex(id);
        bd.deletaNome(index);
        System.out.println("deletou");

        return "redirect:controle?function=listarNome";
    }
}


