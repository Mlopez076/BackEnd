/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar Garibay
 */
public class Login {
    
    public void ingresar(String User, String Pass) {
       Connection con = Connect.getConnection();
        ResultSet rs = null;
         PreparedStatement pst = null;
        if (User.equals("") || Pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Uno o mas campos estan vacios. Favor de llenarlos.");
        } else {
            try {
               
                pst = con.prepareStatement("select APELLIDOMATERNO, RFC from BASE.PERSONAS where APELLIDOMATERNO='" + User
                        + "' and RFC ='" + Pass + "'");
                   PreparedStatement ps =pst;
                rs = pst.executeQuery();
                if (rs.next()) {
                    //añade metodo de redirigir si es necesario
                  //  dispose();
                    //new Home().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Vuelve a intentar de nuevo.");
                }
            } catch (SQLException e) {
                System.err.print(e.toString());
                JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
            }
        }
    }
}
