package br.com.webApp.servletpt1.controler;
import br.com.webApp.servletpt1.modelo.BD;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/listaNomesService")
public class listaNomesService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BD bd = new BD();

        String header = req.getHeader("accept");
        //String param = req.getParameter("function");

        //Se a requisicao for atraves de URI, o header sera desconsiderado.
        //Pois o header deverá apenas receber valor (Accept) caso seja solicitado via HTTPService
      //  if(param != null){
       //     header = param;
     //   }

        PrintWriter out = resp.getWriter();
        if(header.contains("xml")){

            XStream xstream = new XStream();
            String xml = xstream.toXML(bd.getListNomes());
            resp.setContentType("aplication/xml");
            out.print(xml);

        }else if (header.contains("json")){

            Gson json = new Gson();
            String listNomesJson = json.toJson(bd.getListNomes());
            resp.setContentType("application/json");
            out.print(listNomesJson);

        }else{
            out.print("{no content}");
        }


    }
}
