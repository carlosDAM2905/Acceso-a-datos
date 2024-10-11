package manejodeficheros.ejerciciosaula.ejercicio1;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {


        System.out.println("Escribe el nombre del fichero");
        Scanner teclado = new Scanner(System.in);

        String ruta = "src/manejodeficheros/ejerciciosaula/ejercicio1/" + teclado.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("El fichero existe");

            if (fichero.isDirectory()) {
                System.out.println("Es un directorio");
            } else {
                System.out.println("Es un fichero");
                System.out.println("Nombre del fichero: " + fichero.getName());
                System.out.println("Tamaño del fichero: " + fichero.length() + " bytes");
                System.out.println("Read " + fichero.canRead());
                System.out.println("Write " + fichero.canWrite());
            }

        } else {
            System.out.println("El fichero no existe");
        }
    }
}
