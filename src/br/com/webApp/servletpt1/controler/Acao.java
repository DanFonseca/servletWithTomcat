package br.com.webApp.servletpt1.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Acao {
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}

