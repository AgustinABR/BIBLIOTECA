import java.util.Scanner;

public class Biblioteca {

    
    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String NEGRITA = "\u001B[1m";
    
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Pepe", "12345", false);
        Usuario usuario2 = new Usuario("Maria", "54321", true);
        Libro libro1 = new Libro("El quijote", "Miguel de Cervantes", Categoria.COMEDIA, 123456);
        Libro libro2 = new Libro("Harry Potter", "JK Rowling", Categoria.FANTASIA, 654321);
        menuAdmin();
    }
    
    public static void menuAdmin() {
        Scanner sc = new Scanner(System.in);
        
        String nombre = usuario1.getNombre();
        String contrasena
        

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

        int opcion = sc.nextInt();
        
        switch (opci) {
            case value:
                
                break;
        
            default:
                break;
        }

          if (opci == 1) {
          System.out.print("Título: ");
          String tit = sc.nextLine();
          System.out.print("Autor: ");
          String aut = sc.nextLine();
          //GestorLibro.agregarLibro(tit, aut);
          
          } else if (opci == 2) {
          //GestorLibro.mostrarLibros();
          
          } else if (opci == 3) {
          System.out.print("Usuario: ");
          String usu = sc.nextLine();
          System.out.print("Contraseña: ");
          String contra = sc.nextLine();
          
          }
         
    }

}