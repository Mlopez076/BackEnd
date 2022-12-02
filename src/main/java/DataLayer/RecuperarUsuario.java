
package DataLayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RecuperarUsuario", urlPatterns = {"/RecuperarUsuario"})
public class RecuperarUsuario extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
         String Correo=request.getParameter("Correo");
          String Contrasenia=request.getParameter("Contrasenia");
           String confirmar=request.getParameter("confirmar");
             Usuarios Reg=new Usuarios();
             Reg.setNombre(nombre);
             Reg.setApellidoMa("");
             Reg.setApellidoPa("");
             if(Contrasenia.equals(confirmar)){
             Reg.setCorreo(Correo);
             }
             Reg.setPassword(Contrasenia);
             request.setAttribute("Registro", Reg);
             request.getRequestDispatcher("Inicio.html").forward(request, response);
             
             
    }

   
}
