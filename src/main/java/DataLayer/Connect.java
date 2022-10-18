package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OraclePreparedStatement;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Connect {

    private static Connection conn = null;
    private static String login = "Backend";
    private static String clave = "12345";
    private static String url = "jdbc:oracle:thin:@25.37.209.77:1521:XE";

    public static void main(String[] args) {
        Connect c = new Connect();
        getConnection();
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
