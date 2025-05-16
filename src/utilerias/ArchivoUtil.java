package utilerias;
import java.io.*;
import java.util.*;

public class ArchivoUtil {
    public static void escribirArchivo(String nombreArchivo, List<String> datos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, false))) {
            for (String linea : datos) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static List<String> leerArchivo(String nombreArchivo) {
        List<String> datos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                datos.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return datos;
    }
}

