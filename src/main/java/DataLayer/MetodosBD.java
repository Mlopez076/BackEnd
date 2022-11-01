/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar Garibay
**/


public class MetodosBD implements IClienteDao{
    


	@Override
    public boolean registrar(Usuarios cliente){
    
        String sql="INSERT INTO PERSONAS values (NULL,'"+cliente.getNombre()+"','"+cliente.getApellidoPa()+"','"+cliente.getApellidoMa()+"')";
          Statement stm= null;
   Connection con=null;
    boolean registrar=false;
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
			System.out.println("Error: Clase MetodosBD, método registrar");
			e.printStackTrace();
		}
            return registrar;
		

    }

    @Override
    public List<Usuarios> obtener() {
        Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM CLIENTE ORDER BY ID";
		
		List<Usuarios> listaCliente= new ArrayList<Usuarios>();
		
		try {			
			co =Connect.getConnection();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Usuarios c=new Usuarios();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellidoPa(rs.getString(3));
				c.setApellidoMa(rs.getString(4));
				listaCliente.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase MetodosBD, método obtener");
			e.printStackTrace();
		}
		
		return listaCliente;
	
    }

    @Override
    public boolean actualizar(Usuarios cliente) {
                Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE PERSONAS SET NOMBRE='"+cliente.getNombre()+"', APELLIDOPATERNO='"+cliente.getApellidoPa()+"', APELLIDOMATERNO='"+cliente.getApellidoPa()+"'" +" WHERE ID="+cliente.getId();
		try {
			connect=Connect.getConnection();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase MetodosBD, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
    }

    @Override
    public boolean eliminar(Usuarios cliente) {
    Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getId();
		try {
			connect=Connect.getConnection();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase MetodosBD, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
    }
}
