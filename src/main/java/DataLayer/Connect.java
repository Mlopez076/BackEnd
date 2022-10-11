package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connect {

    private static Connection conn = null;
    private static String login = "Prueba";
    private static String clave = "234509";
    private static String url = "jdbbc:oracle:thin:@localhost:1521";

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.Oracle Driver");
            conn = DriverManager.getConnection(url, login, clave);
        conn.setAutoCommit(false);
        if(conn!=null){
            System.out.println("Conexion establecida");
        }else{
            System.out.println("Conexion erronea");
        }
        
        } catch (ClassNotFoundException | SQLException e)
        {
            
                JOptionPane.showMessageDialog(null, "Conexion erronea");
        }
        return conn;
    }
}
