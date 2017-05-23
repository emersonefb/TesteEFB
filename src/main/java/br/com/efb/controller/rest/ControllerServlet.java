package br.com.efb.controller.rest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by fepweb on 17/05/17.
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String parametro = request.getParameter("logica");
        String nomeDaClasse = "br.com.efb.controller.rest.logica." + parametro;

        String pagina = null;
        
        try {
            Class classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.newInstance();
            pagina = logica.executa(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        
        request.getRequestDispatcher(pagina).forward(request, response);
    }
}