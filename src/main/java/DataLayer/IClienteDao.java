/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;

import java.util.List;

public interface IClienteDao {	
	public boolean registrar(Usuarios cliente);
	public List<Usuarios> obtener();
	public boolean actualizar(Usuarios cliente);
	public boolean eliminar(Usuarios cliente);
}
