import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class hashTable {
    private static ArrayList<Integer>[] Tabla = new ArrayList[10];
    private static Scanner objeto = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        while (true) {
            mostrarMenu();
            opcion = objeto.nextInt();
            
            switch(opcion) {
                case 1:
                    agregarValor();
                    break;
                case 2:
                    eliminarValor();
                    break;
                case 3:
                    cargarDesdeArchivo();
                    break;
                case 4:
                    buscarValor();
                    break;
                case 5:
                    reporteDeDatos();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    objeto.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Opciones:");
        System.out.println("1. Agregar valor");
        System.out.println("2. Eliminar valor");
        System.out.println("3. Cargar desde archivo");
        System.out.println("4. Buscar valor");
        System.out.println("5. Reporte de datos");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarValor() {
        System.out.print("Ingrese valor para almacenar en la tabla: ");
        int valor = objeto.nextInt();
        agregarValor(valor);
    }

    private static void agregarValor(int valor) {
        int clave = hashFunction(valor);
        if (Tabla[clave] == null) {
            Tabla[clave] = new ArrayList<>();
        }
        Tabla[clave].add(valor);
    }

    private static void eliminarValor() {
        System.out.print("Ingrese el valor a eliminar: ");
        int valor = objeto.nextInt();
        int clave = hashFunction(valor);
        if (Tabla[clave] != null) {
            if (Tabla[clave].remove((Integer) valor)) {
                System.out.println("Valor eliminado de la posición " + clave);
            } else {
                System.out.println("Valor no encontrado en la tabla.");
            }
        } else {
            System.out.println("Valor no encontrado en la tabla.");
        }
    }

    private static void cargarDesdeArchivo() {
        System.out.print("Ingrese el nombre del archivo: ");
        String filename = objeto.next();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    int valor = Integer.parseInt(part.trim());
                    agregarValor(valor);
                }
            }
            System.out.println("Datos cargados desde el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void buscarValor() {
        System.out.print("Ingrese el valor a buscar: ");
        int valor = objeto.nextInt();
        int clave = hashFunction(valor);
        if (Tabla[clave] != null && Tabla[clave].contains(valor)) {
            System.out.println("Valor encontrado en la posición " + clave);
        } else {
            System.out.println("Valor no encontrado en la tabla.");
        }
    }

    private static void reporteDeDatos() {
        System.out.println("Reporte detallado de la tabla:");
        for (int i = 0; i < Tabla.length; i++) {
            System.out.println("Index " + i + ":");
            if (Tabla[i] == null || Tabla[i].isEmpty()) {
                System.out.println("   Vacío");
            } else {
                for (Integer valor : Tabla[i]) {
                    System.out.println("   Valor: " + valor);
                }
            }
        }
    }

    private static int hashFunction(int key) {
        return Math.abs(key) % 10;
    }
}
