package manejodeficheros.ejerciciogestiondeinventarios;

import java.io.Serializable;
import java.util.ArrayList;

public class Productos implements Serializable {


    private static int contadorId = 0;
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precio;


    //constructor:

    public Productos(String nombre, int cantidad, double precio) {
        this.idProducto = ++contadorId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //getters y setters:

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    // toString:


    @Override
    public String toString() {
        return "idProducto: " + idProducto + " | " +
                " nombre: " + nombre + " | " +
                " cantidad: " + cantidad + " | " +
                " precio: " + precio;
    }

}
