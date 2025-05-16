package modelo;

import utilerias.ArchivoUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorVentas {

    private List<Venta> ventas = new ArrayList<>();
    private static final String ARCHIVO_VENTAS = "ventas.csv";

    public void cargarVentas(List<Libro> inventario) {
        if (!Files.exists(Paths.get(ARCHIVO_VENTAS))) {
            System.out.println(" Archivo no encontrado: " + ARCHIVO_VENTAS);
            System.out.println("Se creará un archivo vacío.");
            crearArchivoVacio(ARCHIVO_VENTAS);
            return;
        }

        ventas = ArchivoUtil.leerArchivo(ARCHIVO_VENTAS).stream()
                .map(linea -> Venta.fromCSV(linea, inventario))
                .collect(Collectors.toList());
    }

    public List<Venta> getVentas() { //
        return ventas;
    }

    public static void crearArchivoVacio(String nombreArchivo) {
        List<String> encabezado = List.of("Titulo|Cantidad|Fecha");
        ArchivoUtil.escribirArchivo(nombreArchivo, encabezado);
        System.out.println("Archivo creado y inicializado: " + nombreArchivo);
    }

    public void registrarVenta(String titulo, int cantidadVendida, LocalDate fecha, List<Libro> inventario) {
        Optional<Libro> libroOpt = inventario.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();

        if (libroOpt.isPresent()) {
            Libro libro = libroOpt.get();
            if (libro.getStock() >= cantidadVendida) {
                Venta nuevaVenta = new Venta(libro, cantidadVendida, fecha);
                ventas.add(nuevaVenta);
                libro.reducirStock(cantidadVendida);
                guardarVentas(); // Guarda automáticamente después de cada venta
                System.out.println(" Venta registrada correctamente.");
            } else {
                System.out.println(" Stock insuficiente.");
            }
        } else {
            System.out.println(" Libro no encontrado.");
        }
    }

    public void mostrarVentas() {
        System.out.println("--------- Ventas ---------");
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            ventas.forEach(System.out::println);
        }
    }

    public void guardarVentas() {
        List<String> datos = ventas.stream()
                .map(Venta::toCSV).
                collect(Collectors.toList());
        ArchivoUtil.escribirArchivo(ARCHIVO_VENTAS, datos);
    }
}

