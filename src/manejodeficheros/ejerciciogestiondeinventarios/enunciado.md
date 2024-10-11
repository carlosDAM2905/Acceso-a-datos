Te propongo un ejercicio que combina la lectura y escritura de ficheros binarios con el uso de InputStream y OutputStream, además de BufferedReader y BufferedWriter para mejorar la eficiencia de la lectura y escritura de datos.

Ejercicio: Gestión de Inventario en Binario
Descripción:
Vas a crear un programa que gestione un inventario de productos utilizando un fichero binario. El programa debe permitir:

Agregar productos: Se añadirán productos con un identificador único, nombre, cantidad y precio.
Leer productos: Se leerán los productos desde el fichero binario y se mostrarán en la consola.
Buscar un producto por ID: El programa debe permitir buscar un producto por su identificador y mostrar la información relacionada.
Requisitos:
Crear una clase Producto que tenga los atributos: id (int), nombre (String), cantidad (int) y precio (double).
Utilizar BufferedReader y BufferedWriter para leer y escribir los datos desde y hacia el fichero binario.
Implementar métodos para añadir un nuevo producto, leer todos los productos, y buscar un producto por su ID.
Asegurarte de que la escritura no sobreescriba los datos, sino que los agregue (append).