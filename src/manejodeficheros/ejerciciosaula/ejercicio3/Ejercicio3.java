package manejodeficheros.ejerciciosaula.ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Partiendo del fichero de csv de ejemplo, crear un programa de Java que permita al
usuario añadir datos nuevos a ese fichero, utilizando el mismo formato que los ya
existentes.
 */

public class Ejercicio3 {
    public static void main(String[] args) {

        String ruta = "src/manejodeficheros/ejerciciosaula/ejercicio3/Restaurantes.csv";

        File fichero = new File(ruta);

        if (fichero.exists()) {

            try (FileWriter escribir = new FileWriter(fichero, true)){

                escribir.write(pedirDatos());


            } catch (IOException e) {
                System.out.println("Ha habido un error al escribir en el fichero " + e.getMessage());
            }

        } else {
            System.out.println("El fichero no existe");
        }

    }

    public static String pedirDatos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce nombre");
        String nombre = teclado.nextLine();
        System.out.println("Introduce dirección");
        String direccion = teclado.nextLine();
        System.out.println("Introduce ciudad");
        String ciudad = teclado.nextLine();
        System.out.println("Introduce estado");
        String estado = teclado.nextLine();
        System.out.println("Introduce código postal");
        String codigoPostal = teclado.nextLine();

        return nombre + "," + direccion + "," + ciudad + "," + estado + "," + codigoPostal + "\n";
    }
}
