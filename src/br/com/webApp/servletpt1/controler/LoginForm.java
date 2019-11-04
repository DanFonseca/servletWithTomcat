package br.com.webApp.servletpt1.controler;

import br.com.webApp.servletpt1.modelo.BD;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginForm extends HttpServlet implements Acao {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {

       return "forward:login.jsp";

    }
}
