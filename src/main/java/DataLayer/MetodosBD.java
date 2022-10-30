/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar Garibay
 */
<<<<<<< Updated upstream:src/main/java/DataLayer/Catalogos.java
public class Catalogos {
    
    String[] Catalogos;
    
    int[] ID;
    
    public void LlenarCatalogos(){
    for(int i=0; i>ID.length; i++){
        
        for(int e=0; e>Catalogos.length;e++){
        }
    }
=======


public class MetodosBD {
    
  Statement stm= null;
   Connection con=null;
    boolean registrar=false;
    public void registrar(Usuarios cliente){
    
        String sql="INSERT INTO cliente values (NULL,'"+cliente.getNombre()+"','"+cliente.getApellidoPa()+"','"+cliente.getApellidoMa()+"')";
        
        try {			
			con =Connect.getConnection();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
                        
                        if(registrar==true){
                            System.out.println("Registro Exitoso");
                        }else{
                            System.out.println("Error al registrar");
                        }
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método registrar");
			e.printStackTrace();
		}
		
>>>>>>> Stashed changes:src/main/java/DataLayer/MetodosBD.java
    }
}
