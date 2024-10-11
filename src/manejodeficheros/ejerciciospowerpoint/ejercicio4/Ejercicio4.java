package manejodeficheros.ejerciciospowerpoint.ejercicio4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {

        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio4/fichero.txt";

        // Array con varios Strings
        String[] array = {"hola", "caracola", "como", "estás"};

        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("El fichero ya existe " + fichero.getAbsolutePath());

        } else {
            try {
                if (fichero.createNewFile()) {
                    System.out.println("Fichero creado con éxito");
                }

                } catch (IOException e) {
                    System.out.println("Error al crear el fichero: " + e.getMessage());
                }
            }

            try (FileWriter fw = new FileWriter(fichero)) {
                for (int i = 0; i < array.length; i++) {
                    fw.write(array[i] + " *\n");
                }
                System.out.println("Texto escrito con éxito en el fichero");

            } catch (IOException e) {
                System.out.println("Error al escribir en el fichero");
            }
        }
    }







