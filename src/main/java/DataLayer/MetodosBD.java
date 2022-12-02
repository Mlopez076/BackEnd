/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar Garibay
*
 */
public class MetodosBD implements IClienteDao {

    @Override
    public boolean registrar(Usuarios cliente) {

        // String sql="INSERT INTO PERSONAS values (1,"+cliente.getNombre()+","+cliente.getApellidoPa()+","+cliente.getApellidoMa()+",12/10/2021,Siempre,Floridacity,1,2,RFC,si,13/10/2021,13/10/2021"+")";
        //  Statement stm= null;
        Connection con = null;

        String sql = "insert into SYSTEM.PERSONAS(PERSONALLAVE,NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO,FECHANACIMIENTO,SEXO,CALLE,NUMEROEXTERIOR,NUMEROINTERIOR,RFC,ACTIVO,FECHACREACION,FECHAMODIFICACION) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        con = Connect.getConnection();

        boolean registrar = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidoPa());
            ps.setString(4, cliente.getApellidoMa());
            ps.setString(5, "12/10/2021");
            ps.setString(6, "H");
            ps.setString(7, "a");
            ps.setString(8, "14");
            ps.setString(9, "14");
            ps.setString(10, cliente.getPassword());
            ps.setString(11, "1");
            ps.setString(12, "12/10/2021");
            ps.setString(13, "12/10/2021");
            ps.setInt(1, cliente.getId());

            //   ps.setString(0, cliente.getNombre());
            ps.executeUpdate();
            registrar = true;
            //stm.close();
            con.close();

            if (registrar == true) {
                System.out.println("Registro Exitoso");
            } else {
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
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM  SYSTEM.PERSONAS ORDER BY PERSONALLAVE";

        List<Usuarios> listaCliente = new ArrayList<Usuarios>();

        try {
            co = Connect.getConnection();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuarios c = new Usuarios();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidoPa(rs.getString(3));
                c.setApellidoMa(rs.getString(4));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            co.close();
            //  System.out.println(listaCliente);
        } catch (SQLException e) {
            System.out.println("Error: Clase MetodosBD, método obtener");
            e.printStackTrace();
        }

        return listaCliente;

    }

    @Override
    public boolean actualizar(Usuarios cliente) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        try {
            //System.out.println(cliente.getNombre());
            connect = Connect.getConnection();
            String sql = "UPDATE SYSTEM.PERSONAS SET NOMBRE=?, APELLIDOPATERNO=?, APELLIDOMATERNO=? WHERE PERSONALLAVE= ? ";

            System.out.println(sql);
            PreparedStatement st = connect.prepareStatement(sql);
            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getApellidoPa());
            st.setString(3, cliente.getApellidoMa());
            st.setInt(4, cliente.getId());

            int Actualizado = st.executeUpdate();
            connect.close();

            if (Actualizado > 0) {
                actualizar = true;
                System.out.println("Acualizado con exito: id " + cliente.getId());
            } else {

                System.err.println("no hay ninguno");
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase MetodosBD, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Usuarios cliente) {
        Connection con = null;
        //Statement stm= null;

        boolean eliminar = false;

        try {
            con = Connect.getConnection();
            PreparedStatement st = con.prepareStatement("DELETE FROM SYSTEM.PERSONAS WHERE PERSONALLAVE=?");
            st.setInt(1, cliente.getId());
            int borrados = st.executeUpdate();
            con.close();
            if (borrados > 0) {
                eliminar = true;
                System.out.println("eliminado con exito: " + cliente.getId());
            } else {

                System.err.println("no hay ninguno");
            }

        } catch (SQLException e) {
            System.out.println("Error: Clase MetodosBD, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
}
