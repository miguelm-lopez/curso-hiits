package exepciones;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ManejoArchivos {
    public static void main(String[] args) throws IOException {
        //nombre del archivo que se creara
        //para cambiar el tipo de archivo solo se cambia el .txt por otro formato
        Path path = Path.of("Productos.txt");
        //te crea un archivo con una lista de valores
        List<String> productos =
                List.of("Producto: Lapiz,","Cantidad:10","Precio: $6.50");
       try {

           Files.write(path, productos);
       }catch (AccessDeniedException e){
           System.out.println("No se puede acceder al archivo");
       }catch (IOException e){
           System.out.println("No se puede escribir en el archivo");
       }
    }
}
