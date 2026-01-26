import java.util.Scanner;

public class Biblioteca {

    public static Scanner sc = new Scanner(System.in);
    public static GestorBiblioteca gb = new GestorBiblioteca();
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
            new Usuario("pepe", "12345", false),
            new Usuario("maria", "54321", true)
    };

    public static void main(String[] args) {
        Usuario usuario = login();

        if (usuario != null) {
            if (usuario.isEsAdmin()) {
                System.out.println(VERDE + "Bienvenido usuario admin: " + usuario.getNombre() + RESET);
                menuAdmin(usuario);
            } else {
                System.out.println(VERDE + "Bienvenido usuario: " + usuario.getNombre() + RESET);
                menuUsuario(usuario);
            }
        } else {
            System.out.println(ROJO + "No se pudo iniciar sesión." + RESET);
        }
    }

    public static Usuario login() {
        System.out.println(AZUL + NEGRITA +
                "\n______________________________\n" +
                "|      LOGIN BIBLIOTECA      |\n" +
                "|____________________________|" + RESET);

        System.out.print(
                AZUL + NEGRITA + "|" + VERDE + " Usuario:                   " + AZUL + NEGRITA + "|" + RESET + " ");
        String nombre = sc.nextLine();

        System.out.print(
                AZUL + NEGRITA + "|" + VERDE + " Contraseña:                " + AZUL + NEGRITA + "|" + RESET + " ");
        String pass = sc.nextLine();

        System.out.println(AZUL + NEGRITA + "|____________________________|" + RESET);

        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getPassword().equals(pass)) {
                System.out.println(VERDE + "Login correcto! Bienvenido " + u.getNombre() + RESET);
                return u;
            }
        }

        System.out.println(ROJO + "Login incorrecto" + RESET);
        return null;
    }

    public static void menuAdmin(Usuario usuario) {
        int opci;

        do {
            System.out.println(AZUL + NEGRITA +
                    "\n________________________________\n" +
                    "|      MENÚ ADMINISTRADOR      |\n" +
                    "|______________________________|" + RESET);

            System.out.println(AZUL + "|" + VERDE + " 1. Agregar libro             " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|" + CYAN + " 2. Eliminar libro            " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|" + MORADO + " 3. Mostrar libros            " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|" + AMARILLO + " 4. Registrar usuario         " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|" + VERDE + " 5. C.Info usuarios           " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|" + CYAN + " 6. Libros prestados          " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|" + MORADO + " 7. Prestar libros            " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|" + AMARILLO + " 8. Devolver libros           " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|" + ROJO + " 0. Salir                     " + AZUL + "|" + RESET);
            System.out.println(AZUL + "|______________________________|" + RESET);

            System.out.print(BLANCO + "\nSeleccione una opción: " + RESET);
            opci = sc.nextInt();

            switch (opci) {

                case 1:
                    System.out.print("Título: ");
                    String tit = sc.nextLine();
                    System.out.print("Autor: ");
                    String aut = sc.nextLine();
                    System.out.print("ISBN: ");
                    int isbn = sc.nextInt();

                    gb.agregarLibro(tit, aut, Categoria.FANTASIA, isbn);
                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:
                    System.out.print("ISBN del libro a eliminar: ");
                    int isbnEliminar = Integer.parseInt(sc.nextLine());
                    gb.eliminarLibro(isbnEliminar);
                    break;

                case 3:
                    gb.mostrarLibros();
                    break;

                case 4:
                    System.out.print("Nombre usuario: ");
                    String nombre = sc.nextLine();

                    System.out.print("Contraseña: ");
                    String pass = sc.nextLine();

                    System.out.println("Eres administrador, si o no?");
                    String respuestaAdmi = sc.nextLine();
                    boolean esAdmin = false;

                    if (respuestaAdmi.toLowerCase().equals("si")) {
                        esAdmin = true;
                    }

                    gb.registrarUsuario(nombre, pass, esAdmin);
                    System.out.println("Usuario registrado.");
                    break;

                case 5:
                    gb.mostrarUsuarios();
                    break;

                case 6:
                    gb.mostrarPrestamosActivos(usuario);
                    break;

                case 7:
                    System.out.print("ID del préstamo: ");
                    int idPrestamo = Integer.parseInt(sc.nextLine());
                    System.out.print("ISBN del libro a prestar: ");
                    int isbnPrestar = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre del usuario: ");
                    String nombreUsuario = sc.nextLine();
                    System.out.print("Fecha de préstamo: ");
                    String fechaPrestamo = sc.nextLine();

                    Usuario usuarioPrestar = gb.getGestorUsuario().buscarUsuarioPorNombre(nombreUsuario);
                    int indiceLibro = gb.getGestorLibro().buscarLibroISBN(isbnPrestar);

                    if (usuarioPrestar != null && indiceLibro != -1) {
                        Libro libro = gb.getGestorLibro().getLibros()[indiceLibro];

                        gb.prestarLibro(idPrestamo, libro, usuarioPrestar, fechaPrestamo);
                    } else {
                        System.out.println("Usuario o libro no encontrado.");
                    }
                    break;

                case 8:
                    System.out.print("ID del préstamo: ");
                    int idDev = Integer.parseInt(sc.nextLine());
                    System.out.print("Fecha de devolución: ");
                    String fechaDev = sc.nextLine();

                    gb.devolverLibro(idDev, fechaDev);
                    break;

                case 0:
                    System.out.println("Saliendo del menú admin...");
                    break;

                default:
                    System.out.println(ROJO + "Opción no válida" + RESET);
            }

        } while (opci != 0);
    }

    static void menuUsuario(Usuario u) {
        int op;

        do {
            System.out.println(MORADO + NEGRITA +
                    "\n________________________________\n" +
                    "|        MENÚ USUARIO          |\n" +
                    "|______________________________|" + RESET);

            System.out.println(MORADO + "|" + CYAN + " 1. Mostrar libros           " + MORADO + "|" + RESET);
            System.out.println(MORADO + "|" + VERDE + " 2. Prestar libro            " + MORADO + "|" + RESET);
            System.out.println(MORADO + "|" + AMARILLO + " 3. Devolver libro           " + MORADO + "|" + RESET);
            System.out.println(MORADO + "|" + ROJO + " 0. Salir                    " + MORADO + "|" + RESET);
            System.out.println(MORADO + "|______________________________|" + RESET);

            System.out.print(BLANCO + "\nSeleccione una opción: " + RESET);
            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    gb.mostrarLibros();
                    break;

                case 2:
                    System.out.print("ID del préstamo: ");
                    int idPrestamo = Integer.parseInt(sc.nextLine());
                    System.out.print("ISBN del libro a prestar: ");
                    int isbnPrestar = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre del usuario: ");
                    String nombreUsuario = sc.nextLine();
                    System.out.print("Fecha de préstamo: ");
                    String fechaPrestamo = sc.nextLine();

                    Usuario usuarioPrestar = gb.getGestorUsuario().buscarUsuarioPorNombre(nombreUsuario);
                    int indiceLibro = gb.getGestorLibro().buscarLibroISBN(isbnPrestar);

                    if (usuarioPrestar != null && indiceLibro != -1) {
                        Libro libro = gb.getGestorLibro().getLibros()[indiceLibro];

                        gb.prestarLibro(idPrestamo, libro, usuarioPrestar, fechaPrestamo);
                    } else {
                        System.out.println("Usuario o libro no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID del préstamo: ");
                    int idDev = Integer.parseInt(sc.nextLine());
                    System.out.print("Fecha de devolución: ");
                    String fechaDev = sc.nextLine();

                    gb.devolverLibro(idDev, fechaDev);
                    break;

                case 0:
                    System.out.println("Saliendo del menú usuario...");
                    break;
            }

        } while (op != 0);
    }

}
