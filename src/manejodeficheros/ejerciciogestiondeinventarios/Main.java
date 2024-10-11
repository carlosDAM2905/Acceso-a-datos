package manejodeficheros.ejerciciogestiondeinventarios;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Productos> productos = new ArrayList<>();


        Inventario.agregarProducto(productos, "Jamón", 50, 125.50);
        Inventario.agregarProducto(productos, "lomo", 25, 75.60);
        Inventario.agregarProducto(productos, "Queso", 10, 40.75);
        Inventario.agregarProducto(productos, "Chorizo", 30, 90.20);
        Inventario.agregarProducto(productos, "Salchichón", 20, 65.80);
        Inventario.agregarProducto(productos, "Aceitunas", 15, 20.50);
        Inventario.agregarProducto(productos, "Pan", 100, 1.25);
        Inventario.agregarProducto(productos, "Leche", 60, 0.95);
        Inventario.agregarProducto(productos, "Café", 80, 10.99);
        Inventario.agregarProducto(productos, "Arroz", 200, 1.15);

        Inventario.crearInventario();
        Inventario.escribirInventario(productos);
        Inventario.mostrarInventario();
        Inventario.mostrarProducto(2);


    }
}
