import java.util.Scanner;

import biblioteca.GestorLibro;
import biblioteca.Usuario;

public class Biblioteca {

    static Scanner sc = new Scanner(System.in);

    static final String RESET = "\u001B[0m";
    static final String ROJO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String AMARILLO = "\u001B[33m";
    static final String AZUL = "\u001B[34m";
    static final String MORADO = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BLANCO = "\u001B[37m";
    static final String NEGRITA = "\u001B[1m";

    public static void main(String[] args) {
        menuAdmin();
    }

    static void menuAdmin() {

        System.out.println(AZUL + NEGRITA +
                "\n________________________________\n" +
                "|      MENÚ ADMINISTRADOR      |\n" +
                "|______________________________|" + RESET);

        System.out.println(AZUL + "|" + VERDE + " 1. Agregar libro             " + AZUL + "|" + RESET);
        System.out.println(AZUL + "|" + CYAN + " 2. Mostrar libros            " + AZUL + "|" + RESET);
        System.out.println(AZUL + "|" + AMARILLO + " 3. Registrar usuario         " + AZUL + "|" + RESET);
        System.out.println(AZUL + "|" + ROJO + " 0. Salir                     " + AZUL + "|" + RESET);
        System.out.println(AZUL + "|______________________________|" + RESET);
        System.out.print(BLANCO + "\nSeleccione una opción: " + RESET);
        
          if (opci == 1) {
          System.out.print("Título: ");
          String tit = sc.nextLine();
          System.out.print("Autor: ");
          String aut = sc.nextLine();
          GestorLibro.agregarLibro(tit, aut);
          
          } else if (opci == 2) {
          GestorLibro.mostrarLibros();
          
          } else if (opci == 3) {
          System.out.print("Usuario: ");
          String usu = sc.nextLine();
          System.out.print("Contraseña: ");
          String contra = sc.nextLine();
          
          }
         
    }

}
