package manejodeficheros.ejerciciospowerpoint.ejercicio6;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio6 {
    public static void main(String[] args) {

        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio6/Empleados.txt";
        File fichero = new File(ruta);
        ArrayList<String> empleados = new ArrayList<>();
        empleados.add("id: 1 | Nombre: Juan");
        empleados.add("id: 2 | Nombre: Andrea");
        empleados.add("id: 3 | Nombre: Carlos");
        empleados.add("id: 4 | Nombre: Laura");
        empleados.add("id: 5 | Nombre: Miguel");

        crearFichero(fichero);
        almacenarEmpleados(fichero, empleados);
        leerEmpleados(fichero);

    }

    // Método para crear el fichero:

    public static void crearFichero(File fichero) {
        if (fichero.exists()) {
            System.out.println("El fichero existe");
        } else {
            try {
                if (fichero.createNewFile()) {
                    System.out.println("Fichero creado con éxito");
                }
            } catch (IOException e) {
                System.out.println("Error, no se ha creado el fichero " + e.getMessage());
            }
        }
    }

    // Método almacenarEmpleados

    public static void almacenarEmpleados(File fichero, ArrayList<String> empleados) {
        try (FileWriter fw = new FileWriter(fichero)) {
            for (String empleado : empleados) {
                fw.write(empleado + "\n");
            }

            System.out.println("Info Empleados almacenada con éxito");

        } catch (IOException e) {
            System.out.println("No se han podido almacenar los empleados");
        }
    }

    // Método para leer el fichero:
    public static void leerEmpleados(File fichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }

        System.out.println("\nLectura de empleados realizada con éxito");
    }
}
