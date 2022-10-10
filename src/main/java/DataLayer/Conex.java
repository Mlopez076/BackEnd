/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luis Fernando P.H
 */
public class Conex {
    
    private String url;
    private String server;
    private String puerto;
    private String bd;
    private String user;
    private String pwd;
    private String driver;
    private String insSql;
    private static Conex instancia;
    private Connection con;
    
    public static Conex getInstance(){
        if(instancia == null){
            instancia = new Conex();
        }
        return instancia;
    }
    
    private Conex(){
        server = "25.37.209.77";
        insSql = "XE";
        puerto="1521";
        bd="Tienda";
        user="Tienda";
        pwd = "Tienda";
        driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
        if(insSql.trim().length() ==0){
          url ="jdbc:sqlserver://" +server +";databaseName="+bd;
        }else{
            url ="jdbc:sqlserver://" +server +"\\"+insSql+":" +puerto +";databaseName="+bd;
        }
     
        System.out.println(url);
        try {
            Class.forName(driver);
             con = DriverManager.getConnection(url,user,pwd);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error a: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error b: " + ex.getMessage());
        }
         
    }
    public Connection getConnection(){
            return con;
        }  
}
