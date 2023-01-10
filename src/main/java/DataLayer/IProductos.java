/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataLayer;

import java.util.List;

/**
 *
 * @author Edgar Garibay
 */
public interface IProductos {
    public boolean registrar(Usuarios cliente);
	public List<Productos> obtener();
	public boolean actualizar(Usuarios cliente);
	public boolean eliminar(Usuarios cliente);
    
}
