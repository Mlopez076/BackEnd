/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;

/**
 *
 * @author Edgar Garibay
 */
public class Usuarios {
  
	private int id;
	
	private String Nombre;
	private String ApellidoPa;
	private String ApellidoMa;
        private String Correo;
	
	public Usuarios() {
	}
	
	public Usuarios(String Nombre,String ApellidoM,String ApellidoPa,String Correo) {
		this.Nombre = Nombre;
		this.ApellidoPa = ApellidoPa;
		this.ApellidoMa = ApellidoM;
                this.Correo=Correo;
                
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPa() {
        return ApellidoPa;
    }

    public void setApellidoPa(String ApellidoPa) {
        this.ApellidoPa = ApellidoPa;
    }

    public String getApellidoMa() {
        return ApellidoMa;
    }

    public void setApellidoMa(String ApellidoMa) {
        this.ApellidoMa = ApellidoMa;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    

	
	@Override
	public String toString() {
		return this.id+", "+this.Nombre+", "+this.ApellidoPa+", "+this.ApellidoMa;
	}
}

