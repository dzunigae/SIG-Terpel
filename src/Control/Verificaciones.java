/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Producto;
//import Entidad.Sistema;
//import Frontera.FramePrincipal;
import DAO.ProductoDAO;
/**
 *
 * @author User
 */
public class Verificaciones {
    
    public ProductoDAO dao= new ProductoDAO();
    
    public Verificaciones() {
    }
    public boolean verificarnombrenuevo(String nombre){
        Producto producto= new Producto();
        producto.setNombre(nombre);
        
        if(dao.leerNOM(producto)==null){
            return true;
        }
        return false;
        /*for(Producto p: FramePrincipal.sistema.getProductos()){
            if(p.getNombre().equals(nombre)){
                return false;
            }
        }
        return true;
*/
    }
    public String AddProductoNuevo(Producto producto){
        /*
        if(!verificarnombrenuevo(producto.getNombre())){
            return "Nombre ya existente!";
        }*/
        if(producto.getCantidad()<0){
            return "No puede inicializar el producto con una cantidad negativa!";
        }
        if(producto.getValor()<0){
            return "No puede inicializar el producto con un valor negativo!";
        }
        //FramePrincipal.sistema.add(producto);
                dao.crear(producto);
        return "Nuevo producto ingresado exitosamente!";
    }
    public boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    public boolean VerificarExistenciaID(int id){
        Producto producto= new Producto();
        producto.setId(id);
        
        if(dao.leerID(producto)==null){
            return false;
        }
        else
            return true;
    }
}
