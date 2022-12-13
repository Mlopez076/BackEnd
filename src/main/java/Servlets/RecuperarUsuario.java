
package Servlets;

import DataLayer.Connect;
import DataLayer.MetodosBD;
import DataLayer.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

@WebServlet(name = "RecuperarUsuario", urlPatterns = {"/RecuperarUsuario"})
public class RecuperarUsuario extends HttpServlet {
 
     private static Connection conn = null;
    private static String login = "BASE";
    private static String clave = "12345";
    private static String url = "jdbc:oracle:thin:@25.39.115.47:1521:XE";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
         String Correo=request.getParameter("Correo");
          String Contrasenia=request.getParameter("Contrasenia");
           String confirmar=request.getParameter("confirmar");
             Usuarios Reg=new Usuarios();
             MetodosBD m=new MetodosBD();
             Connect conexion =new Connect();
             Reg.setNombre(nombre);
             Reg.setApellidoMa("");
             Reg.setApellidoPa("");
             if(Contrasenia.equals(confirmar)){
             Reg.setCorreo(Correo);
             }
             Reg.setPassword(Contrasenia);
            m.registrar(Reg);
            request.setAttribute("Registro", Reg); 
            request.getRequestDispatcher("index.html").forward(request, response);
             
             
    }
   
}
