package manejodeficheros.ejerciciospowerpoint.ejercicio1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {

        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio1/miFichero.txt";

        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("El fichero ya existe");
        } else {
            try {
                if (fichero.createNewFile()) {
                    System.out.println("Fichero creado con éxito");
                }

            } catch (IOException e) {
                System.out.println("No se ha podido crear el fichero " + e.getMessage());
            }
        }


    }
}
