package Entidad;

import java.util.ArrayList;


public class Recibo {
    private ArrayList<Producto> productos_vendidos = new ArrayList();
    private int valor_de_la_venta = 0;
    private String empleado;
    
    public void generar_recibo(){
        
    }
    
    public ArrayList<Producto> getProductos_vendidos() {
        return productos_vendidos;
    }

    public void setProductos_vendidos(ArrayList<Producto> productos_vendidos) {
        this.productos_vendidos = productos_vendidos;
    }

    public int getValor_de_la_venta() {
        return valor_de_la_venta;
    }

    public void setValor_de_la_venta(int valor_de_la_venta) {
        this.valor_de_la_venta = valor_de_la_venta;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    
}
