package manejodeficheros.practica01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String ruta1 = "src/manejodeficheros/practica01/CONCIERTOS.csv";
        String ruta2 = "src/CONCIERTOS.txt";
        String ruta3 = "src/CONCIERTOS.aleatorio";
        String ruta4 = "src/CONCIERTOS.bin";
        String ruta5 = "src/CONCIERTOS.xml";


        ejercicio1(ruta1, ruta2);
        ejercicio2(ruta1, ruta3, 5);
        ejercicio3(ruta1, ruta4);
        ejercicio4(ruta4, ruta5);


    }

    public static void ejercicio1(String ruta1, String ruta2) {

           /*
        1. Leer el fichero “CONCIERTOS.csv” y generar un “CONCIERTOS.txt” con todos los
        datos en minúscula.
         */

        System.out.println("\n============\nEJERCICIO 1\n============\n");

        try (BufferedReader br = new BufferedReader(new FileReader(ruta1));
             FileWriter fw = new FileWriter(ruta2)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                fw.write(linea.toLowerCase() + "\n");
                System.out.println(linea.toLowerCase());
            }

        } catch (IOException e) {
            System.out.printf("Error al leer el fichero " + e.getMessage());
        }
    }

    public static void ejercicio2(String ruta1, String ruta3, int posicion) {
        /*
        Leer el fichero “CONCIERTOS.csv” y generar un fichero “CONCIERTOS.aleatorio”
        de acceso aleatorio donde los campos de cada columna midan lo mismo
        (50,50,30,10)
         */

        System.out.println("\n============\nEJERCICIO 2\n============\n");

        try (RandomAccessFile raf = new RandomAccessFile(ruta3, "rw");
             BufferedReader br = new BufferedReader(new FileReader(ruta1))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");

                String campo0 = String.format("%-50s", campos[0]);
                String campo1 = String.format("%-50s", campos[1]);
                String campo2 = String.format("%-30s", campos[2]);
                String campo3 = String.format("%-10s", campos[3]);


                raf.writeBytes(campo0);
                raf.writeBytes(campo1);
                raf.writeBytes(campo2);
                raf.writeBytes(campo3);


            }


            int bytesPorRegistro = 50 + 50 + 30 + 10;

            raf.seek((long) bytesPorRegistro * posicion);

            byte[] bytes = new byte[bytesPorRegistro];

            int bytesLeidos = raf.read(bytes);

            if (bytesLeidos == bytesPorRegistro) {

                String grupo = new String(bytes, 0, 50);
                String lugar = new String(bytes, 50, 50);
                String fecha = new String(bytes, 100, 30);
                String hora = new String(bytes, 130, 10);

                System.out.println("Registro número: " + posicion);
                System.out.println("Grupo: " + grupo);
                System.out.println("Lugar: " + lugar);
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora:  " + hora);

            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }


    }

    public static void ejercicio3(String ruta1, String ruta4) {

        /*
        Leer el fichero “CONCIERTOS.csv”, generar una clase Conciertos y con ella
        generar un fichero “CONCIERTOS.bin” serializable
         */

        System.out.println("\n============\nEJERCICIO 3\n============\n");

        ArrayList<Conciertos> listaConciertos = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(ruta1))) {

            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] campos = linea.split(";");
                Conciertos concierto = new Conciertos(campos[0], campos[1], campos[2], campos[3]);

                listaConciertos.add(concierto);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta4))) {

            oos.writeObject(listaConciertos);

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero " + e.getMessage());
        }

        //Para deserializar el fichero binario (.bin) que hemos creado:

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta4))) {

            ArrayList<Conciertos> lista = (ArrayList<Conciertos>) ois.readObject();

            for (Conciertos concierto : lista) {
                System.out.println(concierto);
            }


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }


    }

    public static void ejercicio4(String ruta4, String ruta5) {

        //Leer el fichero “CONCIERTOS.bin” serializable y con DOM generar el fichero
        //“CONCIERTOS.XML”

        System.out.println("\n============\nEJERCICIO 4\n============\n");

        ArrayList<Conciertos> listaConciertos = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta4))) {

            listaConciertos = (ArrayList<Conciertos>) ois.readObject();


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero " + e.getMessage());
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element root = doc.createElement("conciertos");
            doc.appendChild(root);

            for (int i = 1; i < listaConciertos.size(); i++) {

                Conciertos concierto = listaConciertos.get(i);

                Element ElementoConcierto = doc.createElement("concierto");
                root.appendChild(ElementoConcierto);

                Element grupo = doc.createElement("grupo");
                grupo.appendChild(doc.createTextNode(concierto.getGrupo()));
                ElementoConcierto.appendChild(grupo);

                Element lugar = doc.createElement("lugar");
                lugar.appendChild(doc.createTextNode(concierto.getLugar()));
                ElementoConcierto.appendChild(lugar);

                Element fecha = doc.createElement("fecha");
                fecha.appendChild(doc.createTextNode(concierto.getFecha()));
                ElementoConcierto.appendChild(fecha);

                Element hora = doc.createElement("hora");
                hora.appendChild(doc.createTextNode(concierto.getHora()));
                ElementoConcierto.appendChild(hora);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ruta5));

            transformer.transform(source, result);

            System.out.println("Fichero XML creado con éxito");

        } catch (TransformerException | ParserConfigurationException e) {
            System.out.println("Error al escribir el fichero XML " + e.getMessage());
        }

    }

}
