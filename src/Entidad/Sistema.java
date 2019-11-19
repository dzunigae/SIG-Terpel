/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author User
 */
import java.util.ArrayList;
public class Sistema {
    private ArrayList<Producto> productos;

    public Sistema() {
        
    }
    public void add(Producto producto){
        productos.add(producto);
    }
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
}
