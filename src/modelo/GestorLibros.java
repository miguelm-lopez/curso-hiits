package modelo;
import utilerias.ArchivoUtil;
import java.util.stream.Collectors;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class GestorLibros {
    //List<Libro> inventario = cargarLibros(ARCHIVO_LIBROS);
    private static final String ARCHIVO_LIBROS = "libros.csv";
    private List<Libro> inventario = new ArrayList<>();



    public void cargarLibros() {
        if (!Files.exists(Paths.get(ARCHIVO_LIBROS))) {
            System.out.println("Archivo no encontrado: " + ARCHIVO_LIBROS);
            System.out.println("Se creará un archivo vacío.");
            crearArchivoVacio(ARCHIVO_LIBROS);
            return;
        }

        inventario = ArchivoUtil.leerArchivo(ARCHIVO_LIBROS).stream()
                .map(Libro::fromCSV)
                .collect(Collectors.toList());
    }

    public static void crearArchivoVacio(String nombreArchivo) {
        List<String> encabezado = List.of("Titulo|Autor|Precio|Género|Stock");
        ArchivoUtil.escribirArchivo(nombreArchivo, encabezado);
        System.out.println(" Archivo creado y inicializado: " + nombreArchivo);
    }

    public void agregarLibro(String titulo, String autor, double precio, String genero, int stock) {
        Libro nuevoLibro = new Libro(titulo, autor, precio, genero, stock);
        inventario.add(nuevoLibro);
        guardarLibros(); //  Guarda automáticamente los cambios
        System.out.println(" Libro agregado correctamente.");
    }

    public List<Libro> getInventario() {
        return inventario;
    }

    public void mostrarInventario() {
        System.out.println("---------- Inventario --------");
        if (inventario.isEmpty()) {
            System.out.println(" No hay libros en el inventario.");
        } else {
            inventario.forEach(System.out::println);
        }
    }

    public void guardarLibros() {
        List<String> datos = inventario.stream().map(Libro::toCSV).toList();
        ArchivoUtil.escribirArchivo(ARCHIVO_LIBROS, datos);
    }
}
