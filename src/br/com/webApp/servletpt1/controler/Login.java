package br.com.webApp.servletpt1.controler;
import br.com.webApp.servletpt1.modelo.BD;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Login extends HttpServlet implements Acao {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        BD banco = new BD();

        if (banco.verificaLogin(usuario, password) != null){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioLogado",usuario);
            return "redirect:controle?function=listarNome";
        }
        return "redirect:controle?function=LoginForm";
    }

}
