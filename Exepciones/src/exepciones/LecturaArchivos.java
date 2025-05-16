package exepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LecturaArchivos {
    public static void main(String[] args) {
        Path path = Path.of("productos.txt");
        try {

            List<String> lineas = Files.readAllLines(path);
            //lineas.forEach(System.out::println);
            for (String linea:lineas){
                System.out.println(linea);
            }
        }catch (IOException e ){
            System.out.println("Error: El archivo no existe o no se puede leer");

        }
    }
}
