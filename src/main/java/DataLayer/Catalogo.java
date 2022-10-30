/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataLayer;

/**
 *
 * @author Edgar Garibay
 */
public class Catalogo {
    String[] Catalogos={"sProducto","dPrecioUnitario","dDescuentoUnitario","iExistencia","FKiProveedorLlave","chActivo","dFechaCreacion","FK_Creacion_iUsuarioLlave","dFechaModificacion","FK_Modificacion_iUsuarioLlave"};
   //String catalogos e id deben estar vacions, y usar el metodo autorrelleno
    int[] ID={1,2,3,4,5,6,7,8,9};
  
    public void LLenarCatalogo(){
    for(int i=0; this.ID.length<i;i++){
        System.out.println("iD:"+ ID[i]);
        for(int e=0; e>Catalogos.length; e++){
            System.out.println("Catalogo "+e+"\n"+Catalogos[e]);
        }
        
    }
    }
    
    
}
