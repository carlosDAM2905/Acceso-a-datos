package manejodeficheros.ejerciciosaula.ejercicio4;

import java.io.*;

/*
Partiendo del fichero de csv de ejemplo, crear un programa de Java que cree una
copia de ese fichero llamada “Restaurants2.csv” que contenga los mismos datos
excepto aquellos correspondientes a los restaurantes cuyo código postal empieza por
6.
 */
public class Ejercicio4 {
    public static void main(String[] args) throws IOException {

        String ruta = "src/manejodeficheros/ejerciciosaula/ejercicio4/Restaurantes.csv";

        String ruta2 = "src/manejodeficheros/ejerciciosaula/ejercicio4/Restaurantes2.csv";


        File fichero = new File(ruta);

        if (fichero.exists()) {


            try (BufferedReader lector = new BufferedReader(new FileReader(fichero));
                FileWriter escribir = new FileWriter(ruta2)) {

                String linea;

                while ((linea = lector.readLine()) != null) {

                    String[] campos = linea.split(",");
                    String codigoPostal = campos[4];
                    System.out.println(linea);

                    if (!codigoPostal.startsWith("6")) {
                        escribir.write(linea + "\n");
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("No se encuentra el fichero " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error en los ficheros " + e.getMessage());
            }

        }

    }
}
