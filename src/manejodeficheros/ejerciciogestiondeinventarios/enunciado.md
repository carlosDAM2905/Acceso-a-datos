La aplicación de Gestión de Inventario permite al usuario realizar varias operaciones sobre un inventario de productos almacenado en un archivo binario. Cada producto tiene un identificador único, nombre, cantidad y precio. La aplicación ofrece funcionalidades clave para manipular y consultar el inventario de manera sencilla y eficiente.

## 🚀 Funcionalidades

- **Agregar productos:** Permite añadir un nuevo producto al inventario, con un identificador único, nombre, cantidad y precio.
- **Leer todos los productos:** Carga y muestra todos los productos almacenados en el archivo binario.
- **Buscar un producto por ID:** Permite buscar un producto específico en el inventario mediante su identificador único y muestra sus detalles.
- **Persistencia de datos:** Los productos se almacenan en un archivo binario (`inventario.bin`) para que los datos se conserven entre ejecuciones de la aplicación.

## 🛠️ Tecnologías y Conceptos Usados

- **Java**: Lenguaje de programación principal utilizado para el desarrollo de la aplicación.
- **Manejo de archivos binarios**: Utilización de `FileInputStream`, `FileOutputStream`, `ObjectInputStream` y `ObjectOutputStream` para leer y escribir datos en un archivo binario.
- **Serialización de objetos**: La aplicación utiliza serialización para almacenar y recuperar objetos de la clase `Producto`.
- **Buffered Streams**: Para optimizar la lectura y escritura de datos, se utiliza `BufferedOutputStream` y `BufferedInputStream`.
- **Colecciones en Java**: Uso de `ArrayList` para almacenar y gestionar los productos en memoria.

## 🧩 Estructura del Proyecto

### Clases Principales

- **Clase `Producto`**: Define las propiedades de un producto (`id`, `nombre`, `cantidad`, `precio`) y métodos para obtener sus valores.
- **Clase `Inventario`**: Contiene los métodos para gestionar el inventario, incluyendo agregar productos, escribir en el archivo, leer el archivo, y buscar productos por ID.

### Métodos Importantes

- `agregarProducto(ArrayList<Productos> productos, String nombre, int cantidad, double precio)`: Añade un nuevo producto al inventario en memoria.
- `escribirInventario(ArrayList<Productos> listaProductos)`: Guarda el inventario en el archivo binario.
- `mostrarInventario()`: Muestra todos los productos almacenados en el archivo binario.
- `mostrarProducto(int id)`: Busca un producto en el inventario por su ID y muestra su información.

## ⚙️ Cómo Usar

1. **Agregar Producto**: Utiliza el método `agregarProducto` para añadir un producto nuevo al inventario en memoria.
2. **Guardar el Inventario**: Usa `escribirInventario` para almacenar todos los productos del inventario en el archivo binario.
3. **Consultar Inventario Completo**: Llama a `mostrarInventario` para ver todos los productos almacenados en el archivo.
4. **Buscar Producto**: Usa `mostrarProducto` proporcionando un `id` para buscar y mostrar un producto específico del inventario.

## 🌟 Posibles Mejoras

- Implementar una interfaz gráfica (GUI) para hacer la aplicación más interactiva.
- Añadir validación de datos para asegurar que los productos no se repitan y que los campos tengan valores válidos.
- Crear un sistema de reportes para generar listados de productos en formato de archivo (como CSV o PDF).

## 📂 Archivo de Ejemplo

La aplicación guarda todos los productos en un archivo binario llamado `inventario.bin`, ubicado en la carpeta `src/manejodeficheros/ejerciciogestiondeinventarios`. Este archivo se crea y actualiza automáticamente al ejecutar las operaciones de escritura.
