/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;
import java.sql.*;
/**
 *
 * @author Edgar Garibay
 */
public class Connect {
    

  public static void main (String args []) throws SQLException
  {
    

    DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

    Connection conn = DriverManager.getConnection
          ("jdbc:oracle:thin:@WIN01:1521:oracleBD", "user", "passw");
         // driver@machineName:port:SID           ,  userid,  password

    Statement stmt = conn.createStatement();
    ResultSet rset = 
              stmt.executeQuery("select BANNER from SYS.V_$VERSION");
    while (rset.next())
         System.out.println (rset.getString(1));   // Print col 1
    stmt.close();
    

  }
 } 