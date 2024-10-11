package manejodeficheros.ejerciciogestiondeinventarios;

import java.io.*;
import java.util.ArrayList;

public class Inventario {

    public static void agregarProducto(ArrayList<Productos> productos, String nombre, int cantidad, double precio) {
        productos.add(new Productos(nombre, cantidad, precio));
    }

    public static void crearInventario() {
        String ruta = "src/manejodeficheros/ejerciciogestiondeinventarios/inventario.bin";

        File fichero = new File(ruta);

        try {
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado");
            } else {
                System.out.println("El fichero ya existe");
            }

        } catch (IOException e) {
            System.out.println("Fichero no encontrado" + e.getMessage());
        }
    }

    public static void escribirInventario(ArrayList<Productos> listaProductos) {
        String ruta = "src/manejodeficheros/ejerciciogestiondeinventarios/inventario.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)))) {

            oos.writeObject(listaProductos);
            System.out.println("Inventario guardado en el fichero");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo" + e.getMessage());
        }

    }

    public static void mostrarInventario() {
        String ruta = "src/manejodeficheros/ejerciciogestiondeinventarios/inventario.bin";

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta)))) {

            ArrayList<Productos> listaProductos = (ArrayList<Productos>) ois.readObject();

            for (Productos producto : listaProductos) {
                System.out.println(producto);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }

    }

    public static void mostrarProducto(int id) {
        String ruta = "src/manejodeficheros/ejerciciogestiondeinventarios/inventario.bin";

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta)))) {

            System.out.println("========================================================================");

            ArrayList<Productos> ListaProductos = (ArrayList<Productos>) ois.readObject();
            boolean encontrado = false;

            for (Productos producto : ListaProductos) {
                if (producto.getIdProducto() == id) {
                    encontrado = true;
                    System.out.println("Aquí tienes el producto que buscas:\n" + producto);
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontro el producto");
            }

            System.out.println("========================================================================");


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }


    }
}
