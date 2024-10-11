package manejodeficheros.ejerciciospowerpoint.ejercicio7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio7 {
    public static void main(String[] args) {

        String[] apellidos = {"Gómez", "Sánchez", "Córdoba", "Jimenez", "Lozano", "Martinez"};

        int[] departamentos = {10, 20, 30, 40, 50, 60};

        double[] salario = {1100.50, 1400.60, 1870.35, 2120.90, 1754.35, 3480.65};

        // Escribimos el fichero llamando al método escribirFichero()
        escribirFichero(apellidos,departamentos,salario);

        // INSERTAR EMPLEADOS:
        insertarEmpleado("Perez", 70, 1920.80);
        insertarEmpleado("Ramirez", 80, 2000);

        // SI QUEREMOS VER TODOS LOS REGISTROS:
        mostrarEmpleados();

        //SI QUEREMOS LEER UN REGISTRO EN CONCRETO, LLAMAMOS AL MÉTODO leerRegistro() E INTRODUCIMOS EL ID DE EMPLEADO QUE QUEREMOS VER, POR EJEMPLO EL 3:
        leerRegistro(idEmpleado(3));

    }
    public static void escribirFichero(String[] apellidos, int[] departamentos, double[] salarios) {

        try(RandomAccessFile fichero = new RandomAccessFile("src/manejodeficheros/ejerciciospowerpoint/ejercicio7/empleados.dat", "rw")) {

            for (int i = 0; i < apellidos.length; i++) {
                fichero.writeInt(i + 1);

                String apellido = apellidos[i];

                if (apellido.length() > 10) {
                    apellido = apellido.substring(0,10);
                } else {
                    apellido = String.format("%-10s", apellido);
                }

                fichero.writeChars(apellido);

                fichero.writeInt(departamentos[i]);

                fichero.writeDouble(salarios[i]);

            }

            System.out.println("Fichero creado con éxito");

        } catch (IOException e) {
            System.out.println("Error de escritura " + e.getMessage());
        }
    }
    public static void leerRegistro(int registro) {
        try (RandomAccessFile fichero = new RandomAccessFile("src/manejodeficheros/ejerciciospowerpoint/ejercicio7/empleados.dat", "r")) {

            fichero.seek(registro);

            int id = fichero.readInt();

            String apellido = "";
            for (int i = 0; i < 10; i++) {
                apellido += fichero.readChar();
            }
            int departamento = fichero.readInt();
            double salario = fichero.readDouble();

            System.out.println("\n===================\nDatos del empleado: \n===================");
            System.out.println("ID: " + id);
            System.out.println("Apellido: " + apellido);
            System.out.println("Departamento: " + departamento);
            System.out.println("Salario: " + salario);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
    public static int idEmpleado(int idEmpleado) {
        int bytesPorRegistro = 36;
        return (idEmpleado - 1) * bytesPorRegistro;
    }
    public static void insertarEmpleado(String apellido, int departamento, double salario) {

        try (RandomAccessFile fichero = new RandomAccessFile("src/manejodeficheros/ejerciciospowerpoint/ejercicio7/empleados.dat", "rw")) {


            long tamañoFichero = fichero.length();

            fichero.seek(tamañoFichero);

            int id = (int) ((tamañoFichero / 36) + 1);
            fichero.writeInt(id);

            if (apellido.length() > 10) {
                apellido = apellido.substring(0, 10);
            } else {
                apellido = String.format("%-10s",apellido);
            }
            fichero.writeChars(apellido);

            fichero.writeInt(departamento);

            fichero.writeDouble(salario);


        } catch (IOException e) {
            System.out.println("Error al insertar empleado " + e.getMessage());
        }
    }
    public static void mostrarEmpleados() {

        try (RandomAccessFile fichero = new RandomAccessFile("src/manejodeficheros/ejerciciospowerpoint/ejercicio7/empleados.dat", "r")) {

            int numeroEmpleados = (int) (fichero.length() / 36);

            for (int i = 1; i <= numeroEmpleados; i++) {
                leerRegistro((i - 1) * 36);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al mostrar empleados " + e.getMessage());
        }

    }
}
