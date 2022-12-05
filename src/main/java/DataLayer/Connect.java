package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connect {

    private static Connection conn = null;
    private static String login = "BASE";
    private static String clave = "12345";
    private static String url = "jdbc:oracle:thin:@25.39.115.47:1521:XE";
 public static void main (String[] args){
      getConnection();
 }
 
   
    public static void UsuarioNuevo(){
      
     Usuarios Reg=new Usuarios();
      /*Borrar
    //  Reg.setNombre("Hernesto");
      Reg.setApellidoPa("Rodriguez");
      Reg.setApellidoMa("Perez");
      Reg.setCorreo("Herodigurez@accitesz.com");
      Reg.setId(4);
      MetodosBD m=new MetodosBD();
        System.out.println( m.obtener());
    //  m.registrar(Reg);
       // System.out.println( "Datos "+m.obtener());
     */
  
      /*Fin de borrar*/
     Usuarios nuevo=new Usuarios(Reg.getNombre(),Reg.getApellidoPa(),Reg.getApellidoMa(),Reg.getCorreo(),Reg.getPassword());
     
       //  Reg.setNombre("messie");
  // m.actualizar(Reg);  
       
    }

    
    public  static Connection getConnection() {
     //   JOptionPane.showMessageDialog(null, Error.class);
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
