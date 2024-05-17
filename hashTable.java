import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

class Entry { // Declarando nodo
    int key; // Identificador
    int value; // Valor a almacenar

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable {
    private int size;
    private LinkedList<Entry>[] table;

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return Math.abs(key) % size;
    }

    public void insertar(int key, int value) {
    int index = hashFunction(key);
    LinkedList<Entry> list = table[index];
    
    // Verificar si la clave ya existe en la lista
    for (Entry entry : list) {
        if (entry.key == key) {
            // Si la clave ya existe, actualizar su valor3
            entry.value = value;
            return;
        }
    }
    
    // Si la clave no existe, agregar un nuevo nodo a la lista
    list.add(new Entry(key, value));
}

    public void eliminar(int key) {
    }

    public void buscar(int key) {}

    public void cargarDesdeArchivo(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    int key = Integer.parseInt(parts[0]);
                    int value = Integer.parseInt(parts[1]);
                    insertar(key, value);
                }
            }
            System.out.println("Datos cargados desde el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void reporte() {
        System.out.println("Reporte detallado de la tabla:");
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ":");
            if (table[i].isEmpty()) {
                System.out.println("   Vacío");
            } else {
                for (Entry entry : table[i]) {
                    System.out.println("   Clave: " + entry.key + ", Valor: " + entry.value);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable hashTable = new HashTable(10); // Tamaño de la tabla
        int opcion;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Ingresar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Cargar desde archivo");
            System.out.println("5. Reporte de la tabla");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la clave (entero): ");
                    int clave = scanner.nextInt();
                    System.out.print("Ingresa el valor (entero): ");
                    int valor = scanner.nextInt();
                    hashTable.insertar(clave, valor);
                    System.out.println("Clave-valor insertada correctamente.");
                    break;
                case 2:
                    System.out.println("Opción 2");
                    
                    break;
                case 3:
                    System.out.println("Opción 3");
                    
                    break;
                case 4:
                    System.out.print("Ingresa el nombre del archivo: ");
                    String filename = scanner.next();
                    hashTable.cargarDesdeArchivo(filename);
                    break;
                case 5:
                    System.out.println("Reporte detallado de la tabla:");
                    hashTable.reporte();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 6.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
