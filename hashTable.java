import java.util.Scanner;

public class HashTable {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Ingresar clave y valor");
            System.out.println("2. Eliminar clave");
            System.out.println("3. Buscar clave");
            System.out.println("4. Cargar desde archivo");
            System.out.println("5. Reporte de la tabla");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la Opción 1");
                    // Lógica para la opción 1
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2");
                    // Lógica para la opción 2
                    break;
                case 3:
                    System.out.println("Has seleccionado la Opción 3");
                    // Lógica para la opción 3
                    break;
                case 4:
                    System.out.println("Has seleccionado la Opción 4");
                    // Lógica para la opción 4
                    break;
                case 5:
                    System.out.println("Has seleccionado la Opción 5");
                    // Lógica para la opción 5
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

  public void insertar() {}

  public void eliminar () {}

  public void buscar() {}

  public void cargar() {}

  public void reporte() {}
}
