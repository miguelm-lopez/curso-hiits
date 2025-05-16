package exepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VerificarEdad {
    public static void verificarEdad(int edad) throws EdadInvalidaException {
        if (edad < 18) {
            throw new EdadInvalidaException("la edad debe " +
                    "ser mayor a 18");
        }

    }

    public static void main(String[] args)/* throws EdadInvalidaException *///solo se usa para que no marque error la excepcion, es mas recomendable usar el try catch
    {
        Scanner entr = new Scanner(System.in);
        boolean control = false;
        while (!control) {
            try {
                System.out.println("Valor edad");
                int edad = entr.nextInt();
                verificarEdad(edad);
                control=true;
                System.out.println("Edad " + edad);
            } catch (EdadInvalidaException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: No se puede convertir a entero");
                entr.nextLine();// al ponerlo aqui ayuda a limpiar el buffer y evita un ciclo repetitivo
            }
        }
    }

}
