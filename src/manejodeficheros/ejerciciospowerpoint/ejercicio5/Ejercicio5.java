package manejodeficheros.ejerciciospowerpoint.ejercicio5;

import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) {



        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio5/fichero.txt";
        File fichero = new File(ruta);

        // En este ejecicio voy a extraer cada parte en métodos (crear fichero, escribir fichero y leer fichero)

        crearFichero(fichero);
        escribirFichero(fichero);
        leerFichero(fichero);

    }

    public static void crearFichero(File fichero) {
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
    }

    public static void escribirFichero(File fichero) {
        try (FileWriter fw = new FileWriter(fichero)) {

            String texto = "He creado un programa en Java que a partir de una cadena de caracteres permita almacenarlos en un fichero de texto.\n" +
                    "El programa añadirá un carácter * para indicar que ha llegado al final del fichero.";

            fw.write(texto + "\n*");


        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero " + e.getMessage());
        }

    }

    // Este es el nuevo método para leer el fichero:
    public static void leerFichero(File fichero) {

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            System.out.println("Lectura del fichero terminada con éxito");

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }
    }

}
