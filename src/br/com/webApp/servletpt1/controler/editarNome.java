package br.com.webApp.servletpt1.controler;

import br.com.webApp.servletpt1.modelo.BD;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editarNome extends HttpServlet implements Acao{

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        BD bd = new BD();
        int index = bd.getIndex(id);

        req.setAttribute("nome", bd.getListNomeByID(index).getNome());
        req.setAttribute("data", bd.getListNomeByID(index).getData());
        req.setAttribute("index", index);

        return "forward:editarNome.jsp";

    }
}
