package exepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
    public static void main(String[] args) {
       // Scanner entrada = new Scanner(System.in);
    try {

        String[] cadenas = {null, "", "hola", "mundo", "test"};
        System.out.println(cadenas[0].length());
    }catch (ArrayIndexOutOfBoundsException ex){
        System.out.println(ex.getMessage());
    }catch (NullPointerException ex){
        System.out.println("El valor de cadena es nulo");
    }
//        try {
//           // String cadena = null;
//          //  System.out.println(cadena.length());
//        }catch (NullPointerException e){
//            System.out.println("El valor de la cadena es nulo");
//        }
//


//        try {
//            System.out.println("Valor de a");
//            int a = entrada.nextInt();
//            System.out.println("Valor de b");
//            int b = entrada.nextInt();
//            int division = a/ b;
//            System.out.println("Division " + division);
//        }catch (ArithmeticException ex){
//            System.out.println("no puede realizar una division entre 0");
//           // ex.printStackTrace();
//        }
//        catch (InputMismatchException ex){
//            System.out.println("no es un valor entero");
//        }
//        finally {
//            System.out.println("Siempre se ejecuta el finally");
//        }
    }
}
