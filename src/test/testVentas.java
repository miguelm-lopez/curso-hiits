package test;

import modelo.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class testVentas {

    private static final GestorLibros gestorLibros = new GestorLibros();
    private static final GestorVentas gestorVentas = new GestorVentas();
    private static final GestionReportes.GestorReportes gestorReportes = new GestionReportes.GestorReportes();

    public static void main(String[] args) {
        gestorLibros.cargarLibros();
        gestorVentas.cargarVentas(gestorLibros.getInventario());

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Gestión de Librería ---");
            System.out.println("1. Registrar nueva venta");
            System.out.println("2. Ver inventario");
            System.out.println("3. Agregar un nuevo libro");
            System.out.println("4. Ver reportes");
            System.out.println("5. Ver ventas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> registrarVenta(scanner);
                case 2 -> gestorLibros.mostrarInventario();
                case 3 -> agregarLibro(scanner);
                case 4 -> gestorReportes.mostrarMenuReportes();
                case 5 -> gestorVentas.mostrarVentas();
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private static void registrarVenta(Scanner scanner) {
        System.out.println("Ingrese el título del libro vendido:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese la cantidad vendida:");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        LocalDate fecha = LocalDate.now();

        gestorVentas.registrarVenta(titulo, cantidad, fecha, gestorLibros.getInventario());
    }

    private static void agregarLibro(Scanner scanner) {
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor:");
        String autor = scanner.nextLine();
        System.out.println("Ingrese el precio:");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        System.out.println("Ingrese el género:");
        String genero = scanner.nextLine();
        System.out.println("Ingrese el stock:");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        gestorLibros.agregarLibro(titulo, autor, precio, genero, stock);
    }

    }

