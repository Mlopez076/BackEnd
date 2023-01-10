/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edgar Garibay
 */
public class Productos implements IProductos  {
    public boolean registrar(Usuarios cliente) {

        // String sql="INSERT INTO PERSONAS values (1,"+cliente.getNombre()+","+cliente.getApellidoPa()+","+cliente.getApellidoMa()+",12/10/2021,Siempre,Floridacity,1,2,RFC,si,13/10/2021,13/10/2021"+")";
        //  Statement stm= null;
        Connection con = Connect.getConnection();

        String sql = "insert into BASE.PERSONAS(PERSONALLAVE,NOMBRE, APELLIDOPATERNO, APELLIDOMATERNO,FECHANACIMIENTO,SEXO,CALLE,NUMEROEXTERIOR,NUMEROINTERIOR,RFC,ACTIVO,FECHACREACION,FECHAMODIFICACION) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    

        boolean registrar = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidoPa());
            ps.setString(4, cliente.getCorreo());//Apellido Materno reemplazado por correo
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

  
    public List<Productos> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM  BASE.PRODUCTOS ORDER BY PRODUCTOLLAVE";

        List<Productos> listaProducto = new ArrayList<Productos>();

        try {
            co = Connect.getConnection();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
               Productos producto=new Productos(Productollave,Existencias,Proveedorllave,Producto,fechaCreacion,fechaModificacion,PrecioUnidad,DescuentoUnidad,activo);
               producto.setProductollave(rs.getInt(1));
               producto.setProducto(rs.getString (2));
               producto.setPrecioUnidad(rs.getFloat(3));
               producto.setDescuentoUnidad(rs.getFloat(4));
               producto.setExistencias(rs.getInt(5));
               producto.setProveedorllave(rs.getInt(6));
               producto.setActivo(rs.getString(7));
               producto.setFechaCreacion(rs.getString(8));
               producto.setFechaModificacion(rs.getString(8));
               
               
                listaProducto.add(producto);
            }
            stm.close();
            rs.close();
            co.close();
            //  System.out.println(listaCliente);
        } catch (SQLException e) {
            System.out.println("Error: Clase MetodosBD, método obtener");
            e.printStackTrace();
        }

        return listaProducto;

    }


    public boolean actualizar(Usuarios cliente) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        try {
            //System.out.println(cliente.getNombre());
            connect = Connect.getConnection();
            String sql = "UPDATE BASE.PERSONAS SET NOMBRE=?, APELLIDOPATERNO=?, APELLIDOMATERNO=? WHERE PERSONALLAVE= ? ";

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

   
    public boolean eliminar(Usuarios cliente) {
        Connection con = null;
        //Statement stm= null;

        boolean eliminar = false;

        try {
            con = Connect.getConnection();
            PreparedStatement st = con.prepareStatement("DELETE FROM BASE.PERSONAS WHERE PERSONALLAVE=?");
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
  
    
    
    public int Productollave,  Existencias, Proveedorllave;
   public String Producto, fechaCreacion,  fechaModificacion;
   public float PrecioUnidad, DescuentoUnidad;
   public String activo;
    public Productos(int Productollave, int Existencias, int Proveedorllave, String Producto, String fechaCreacion, String fechaModificacion, float PrecioUnidad, float DescuentoUnidad, String activo) {
        this.Productollave = Productollave;
        this.Existencias = Existencias;
        this.Proveedorllave = Proveedorllave;
        this.Producto = Producto;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.PrecioUnidad = PrecioUnidad;
        this.DescuentoUnidad = DescuentoUnidad;
        this.activo = activo;
    }

    public int getProductollave() {
        return Productollave;
    }

    public void setProductollave(int Productollave) {
        this.Productollave = Productollave;
    }

    public int getExistencias() {
        return Existencias;
    }

    public void setExistencias(int Existencias) {
        this.Existencias = Existencias;
    }

    public int getProveedorllave() {
        return Proveedorllave;
    }

    public void setProveedorllave(int Proveedorllave) {
        this.Proveedorllave = Proveedorllave;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public float getPrecioUnidad() {
        return PrecioUnidad;
    }

    public void setPrecioUnidad(float PrecioUnidad) {
        this.PrecioUnidad = PrecioUnidad;
    }

    public float getDescuentoUnidad() {
        return DescuentoUnidad;
    }

    public void setDescuentoUnidad(float DescuentoUnidad) {
        this.DescuentoUnidad = DescuentoUnidad;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    
    
    
}
