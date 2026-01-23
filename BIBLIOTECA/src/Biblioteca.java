import java.util.Scanner;

public class Biblioteca {

    public static Scanner sc = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String NEGRITA = "\u001B[1m";

    public static Usuario[] usuarios = {
        new Usuario("Pepe", "12345", false),
        new Usuario("María", "54321", true)
    };

    public static void main(String[] args) {
        Usuario usuario = login(); 

        if (usuario != null) {
            if (usuario.isAdmin()) {
                menuAdmin();
            } else {
                System.out.println(VERDE + "Bienvenido usuario: " + usuario.getNombre() + RESET);
            }
        } else {
            System.out.println(ROJO + "No se pudo iniciar sesión." + RESET);
        }
    }

    public static Usuario login() {
        System.out.println(AZUL + NEGRITA +
                "\n________________________________\n" +
                "|      LOGIN BIBLIOTECA      |\n" +
                "|____________________________|" + RESET);

        System.out.print(AZUL + "|" + VERDE + " Usuario:           " + AZUL + "|" + RESET + " ");
        String nombre = sc.nextLine();

        System.out.print(AZUL + "|" + VERDE + " Contraseña:        " + AZUL + "|" + RESET + " ");
        String pass = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getContrasena().equals(pass)) {
                System.out.println(VERDE + "Login correcto! Bienvenido " + u.getNombre() + RESET);
                return u;
            }
        }

        System.out.println(ROJO + "Login incorrecto" + RESET);
        return null;
    }

    public static void menuAdmin() {
        System.out.println(AZUL + NEGRITA +
                "\n________________________________\n" +
                "|      MENÚ ADMINISTRADOR      |\n" +
                "|______________________________|" + RESET);

        System.out.println(AZUL + "|" + VERDE + " 1. Agregar libro             " + AZUL + "|" + RESET);
        System.out.println(AZUL + "|" + CYAN + " 2. Mostrar libros            " + AZUL + "|" + RESET);
        System.out.println(AZUL + "|" + AMARILLO + " 3. Registrar usuario         " + AZUL + "|" + RESET);
        System.out.println(AZUL + "|" + ROJO + " 0. Salir                     " + AZUL + "|" + RESET);

        System.out.print(BLANCO + "\nSeleccione una opción: " + RESET);
        int opci = Integer.parseInt(sc.nextLine());

        switch (opci) {
            case 1:
                System.out.print("Título: ");
                String tit = sc.nextLine();
                System.out.print("Autor: ");
                String aut = sc.nextLine();
                System.out.println("Libro agregado: " + tit + " - " + aut);
                break;
            case 2:
                System.out.println("Aquí se mostrarían los libros.");
                break;
            case 3:
                System.out.print("Usuario: ");
                String usu = sc.nextLine();
                System.out.print("Contraseña: ");
                String contra = sc.nextLine();
                System.out.println("Usuario registrado: " + usu);
                break;
            case 0:
                System.out.println("Saliendo del menú admin...");
                break;
            default:
                System.out.println(ROJO + "Opción no válida" + RESET);
        }
    }
}