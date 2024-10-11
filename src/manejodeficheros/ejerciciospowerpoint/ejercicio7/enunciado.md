# Ejercicio: Inserción de datos de empleados en fichero

## Enunciado

1. Crea un programa en Java que inserte datos de empleados en un fichero aleatorio, indicando apellido, departamento y salario. Para cada empleado se insertará un identificador (mayor que cero) y coincidirá con el índice + 1 que recorra los arrays.

2. Muestra los datos introducidos en el fichero.  

3. Consulta los datos de un empleado en particular del fichero que has creado.  

4. Crea un método que inserte los datos de un empleado nuevo en el fichero que has creado (puedes insertar los datos desde la consola o como argumentos).


### Requisitos

1. **Identificador**: 4 bytes, entero.
2. **Apellido**: 10 caracteres UNICODE, cada carácter ocupa 2 bytes (20 bytes en total).
3. **Departamento**: 4 bytes, entero.
4. **Salario**: 8 bytes, tipo `double`.

### Notas

- Asegúrate de utilizar un formato de archivo adecuado para manejar los datos de los empleados de manera aleatoria.
- Los identificadores deben ser únicos y generarse a partir de la posición en el array (índice + 1).
- El posicionamiento para empezar a recorrer los registros es 0 y para recuperar los datos hay que añadir 36 a la variable del posicionamiento.

---


### Objetivos del ejercicio

- Practicar la escritura en ficheros aleatorios en Java.
- Practicar la lectura en ficheros aleatorios en Java.
- Aplicar la manipulación de bytes para almacenar diferentes tipos de datos.
- Familiarizarse con la manipulación de datos en formato binario.