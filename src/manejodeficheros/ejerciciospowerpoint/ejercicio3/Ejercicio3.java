package manejodeficheros.ejerciciospowerpoint.ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {

        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio3/fichero.txt";

        File fichero = new File(ruta);


        if (fichero.exists()) {
            System.out.println("El fichero ya existe");

        } else  {
            System.out.println("Creando fichero");
            try {
                if (fichero.createNewFile()) {
                    System.out.println("Fichero creado con éxito");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el fichero");
            }
        }

        try (FileWriter fw = new FileWriter(fichero, true)) {

            String texto = "He creado un programa en Java que a partir de una cadena de caracteres permita almacenarlos en un fichero de texto.\n" +
                    "El programa añadirá un carácter * para indicar que ha llegado al final del fichero.";

            fw.write(texto + "\n*");

            } catch (IOException e) {
            System.out.println("Error al escribir en el fichero " + e.getMessage());
        }


    }
}

