package modelo;

import utilerias.ArchivoUtil;

import java.util.Scanner;

public class GestionReportes {
    public static class GestorReportes {
        public void mostrarMenuReportes() {
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("\n--- Reportes ---");
                System.out.println("1. Libros en inventario");
                System.out.println("2. Ventas realizadas");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> mostrarLibros();
                    case 2 -> mostrarVentas();
                    case 3 -> System.out.println("Saliendo del menú de reportes...");
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 3);
        }

        private void mostrarLibros() {
            System.out.println("Libros en inventario:");
            ArchivoUtil.leerArchivo("libros.csv").forEach(System.out::println);
        }

        private void mostrarVentas() {
            System.out.println("Ventas realizadas:");
            ArchivoUtil.leerArchivo("ventas.csv").forEach(System.out::println);
        }


    }
 }
