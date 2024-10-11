package manejodeficheros.ejerciciosaula.ejercicio2;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {


        String ruta = "src/manejodeficheros/ejerciciosaula/ejercicio2/Restaurantes.csv";

        File fichero = new File(ruta);

        if (fichero.exists()) {

            try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {

                String linea = lector.readLine();

                while ((linea = lector.readLine()) != null) {

                    String[] campos = linea.split(","); //Creamos un array para meter los campos del fichero csv
                    String codigoPostal = campos[4]; //Localizamos que el codigo postal ocupa la posición 3 del array, recuerda que la primera posición es [0], y lo guardamos en un String

                    if (codigoPostal.startsWith("6")) { // comprobamos que cada codigo postal comience por 6 y si es así, imprimimos esa línea
                        System.out.println(linea);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("No se encuentra el fichero " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error " + e.getMessage());
            }

        } else {
            System.out.println("El fichero no existe");
        }




    }
}
