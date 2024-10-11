package manejodeficheros.ejerciciosaula.ejercicio5;

import java.io.File;
import java.util.Scanner;


public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre del fichero que deseas eliminar"); //
        String ruta = teclado.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("El fichero existe");

            if (fichero.delete()) {
                System.out.println("Fichero borrado con éxito");
            } else {
                System.out.println("El fichero no se ha podido borrar");
            }

        } else {
            System.out.println("El fichero no existe");
        }

    }
}
