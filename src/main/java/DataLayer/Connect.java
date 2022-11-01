package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connect {

    private static Connection conn = null;
    private static String login = "Backend";
    private static String clave = "12345";
    private static String url = "jdbc:oracle:thin:@25.39.115.47:1521:XE";

    public static void main(String[] args) {
        Connect c = new Connect();
       
         UsuarioNuevo();
   
    }
public static void UsuarioNuevo(){
     Usuarios Reg=new Usuarios();
      /*Borrar*/
      Reg.setNombre("Gerita");
      Reg.setApellidoPa("Hernandez");
      Reg.setApellidoMa("Cortez");
      Reg.setCorreo("gerHer@accitesz.com");
      MetodosBD m=new MetodosBD();
      m.registrar(Reg);
      /*Fin de borrar*/
     Usuarios nuevo=new Usuarios(Reg.getNombre(),Reg.getApellidoPa(),Reg.getApellidoMa(),Reg.getCorreo());
             
}
    public static Connection getConnection() {
        try {
          //  Class.forName("oracle.jdbc.driver.Oracle Driver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);
            if (conn != null) {
                System.out.println("Conexion establecida");
            } else {
                System.out.println("Conexion erronea");
            }

        } catch (SQLException e) {
                 System.out.println(e);
            JOptionPane.showMessageDialog(null, "Conexion erronea: "+e);
        } 
        return conn;

    }

    

    public void desconexion() {
        try {
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al desconectar" + e.getMessage());
        }
    }

}
