package manejodeficheros.ejerciciospowerpoint.ejercicio2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {

        menu();
    }

    public static void menu() {
        int opcion = 0;

        while (opcion != 9) {


            System.out.println("Elige una opción: \n1. Crear directorio \n2. Crear fichero \n3. Eliminar directorio \n4. Eliminar fichero \n5. Mostrar contenido \n6. Escribir fichero \n7. Leer fichero \n8. Abrir fichero en Bloc de Notas \n9. Salir");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    crearDirectorio();
                    break;

                case 2:
                    crearFichero();
                    break;

                case 3:
                    borrarDirectorio();
                    break;

                case 4:
                    borrarFichero();
                    break;

                case 5:
                    mostrarContenido();
                    break;

                case 6:
                    escribirFichero();
                    break;

                case 7:
                    leerFichero();
                    break;

                case 8:
                    abrirBlocDeNotas();
                    break;

                case 9:
                    return;

                default:
                    System.out.println("opción incorrecta");


            }
        }

    }

    public static void crearDirectorio() {

        System.out.println("Introduce nombre del directorio para crearlo");
        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio2/" + teclado.nextLine();

        File nuevoDirectorio = new File(ruta);

        if (nuevoDirectorio.exists()) {
            System.out.println("El directorio ya existe " + nuevoDirectorio.getAbsolutePath());
        } else {

            try {
                if (nuevoDirectorio.mkdir()) {
                    System.out.println("Directorio creado con éxito " + nuevoDirectorio.getAbsolutePath());
                }
            } catch (Exception e) {
                System.out.println("No se ha podido crear el directorio " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
            }

        }

    }

    public static void crearFichero() {
        System.out.println("Introduce ruta del fichero");
        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio2/" + teclado.nextLine();


        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("El fichero ya existe " + fichero.getAbsolutePath());
        } else {
            try {
                if (fichero.createNewFile()) {
                    System.out.println("Fichero creado con éxito " + fichero.getAbsolutePath());
                }
            } catch (IOException e) {
                System.out.println("No se ha podido crear el fichero " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
            }
        }
    }

    public static void borrarFichero() {
        System.out.println("Introduce el nombre del fichero que quieres borrar ");

        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio2/" + teclado.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("El fichero se borrará ¿Estás seguro?");
            String verificacion = teclado.nextLine();
            if (verificacion.equalsIgnoreCase("si")) {
                if (fichero.delete()) {
                    System.out.println("Fichero borrado con éxito");
                } else {
                    System.out.println("No se pudo borrar el fichero");
                }
            }
        } else {
            System.out.println("El fichero no existe");
        }
    }

    public static void borrarDirectorio() {
        System.out.println("Introduce nombre del directorio que quieras borrar");
        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio2/" + teclado.nextLine();

        File directorio = new File(ruta);

        if (directorio.exists()) {
            System.out.println("El directorio se borrará junto a su contenido ¿Estás seguro?");
            String opcion = teclado.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                if (borrarDirectorioConContenido(directorio)) {
                    System.out.println("Directorio eliminado con éxito");
                } else {
                    System.out.println("El directorio no se ha podido eliminar");
                }
            } else {
                System.out.println("Operación cancelada");
            }

        } else {
            System.out.println("El directorio no existe");
        }

    }

    public static boolean borrarDirectorioConContenido(File directorio) {

        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    borrarDirectorioConContenido(archivo);
                }
            }


        }
        return directorio.delete();

    }

    public static void mostrarContenido() {
        System.out.println("Introduce nombre del directorio que quieras mostrar");
        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio2/" + teclado.nextLine();
        File directorio = new File(ruta);

        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();

            if (archivos != null) {
                System.out.println("Contenido del directorio:");

                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        System.out.println("[Directorio]: " + archivo.getName() + " [ruta]: " + archivo.getAbsolutePath());

                    } else {
                        System.out.println("[Archivo]: " + archivo.getName() + " [ruta]: " + archivo.getAbsolutePath());
                    }

                }
            } else {
                System.out.println("El directorio está vacio");
            }

        } else {
            System.out.println("El directorio no existe");
        }

    }

    public static void escribirFichero() {

        System.out.println("en que fichero quieres escribir:");

        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio2/" + teclado.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {

            try (FileWriter escribir = new FileWriter(fichero, true)) {
                System.out.println("Escribe:");
                escribir.write(teclado.nextLine() + "\n");

            } catch (IOException e) {
                System.out.println("No se ha podido escribir en el fichero " + e.getMessage());
                    e.printStackTrace();
            }

        } else {
            System.out.println("El fichero no existe");
        }


    }

    public static void leerFichero() {
        System.out.println("¿Que fichero quieres leer?");
        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio2/" + teclado.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {
            try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {

                String linea;

                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }

            } catch (FileNotFoundException e) {
                System.out.println("No se encuentra el fichero " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Ha habido un error al leer el fichero " + e.getMessage());
            }
        } else {
            System.out.println("El fichero no existe");
        }
    }

    public static void abrirBlocDeNotas() {
        System.out.println("¿Qué fichero quieres abrir?");
        String ruta = "src/manejodeficheros/ejerciciospowerpoint/ejercicio2/" + teclado.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {
            try {
                ProcessBuilder proceso = new ProcessBuilder("notepad.exe", fichero.getAbsolutePath());
                proceso.start();
                System.out.println("Bloc de Notas abierto con éxito");

            } catch (IOException e) {
                System.out.println("No se pudo abrir el Bloc de Notas");
            }
        } else {
            System.out.println("El fichero no existe");
        }

    }



}
