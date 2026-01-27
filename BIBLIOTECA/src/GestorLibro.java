import java.util.Arrays;

public class GestorLibro {

    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";

    private Libro[] libros;
    private static final int MAX = 100;
    private int cantidad;

    public void cargarLibros() {
        agregarLibro(new Libro("El Hobbit", "Tolkien", Categoria.FANTASIA, 111));
        agregarLibro(new Libro("El Señor de los Anillos", "Tolkien", Categoria.FANTASIA, 112));
        agregarLibro(new Libro("Harry Potter", "J.K. Rowling", Categoria.FANTASIA, 113));
        agregarLibro(new Libro("1984", "Orwell", Categoria.CIENCIAFICCION, 221));
        agregarLibro(new Libro("Dune", "Frank Herbert", Categoria.CIENCIAFICCION, 222));
        agregarLibro(new Libro("Fahrenheit 451", "Ray Bradbury", Categoria.CIENCIAFICCION, 223));
        agregarLibro(new Libro("It", "Stephen King", Categoria.TERROR, 331));
        agregarLibro(new Libro("El Resplandor", "Stephen King", Categoria.TERROR, 332));
        agregarLibro(new Libro("Drácula", "Bram Stoker", Categoria.TERROR, 333));
        agregarLibro(new Libro("Los Juegos del Hambre", "Suzanne Collins", Categoria.ACCION, 441));
        agregarLibro(new Libro("Divergente", "Veronica Roth", Categoria.ACCION, 442));
        agregarLibro(new Libro("El Diario de Greg", "Jeff Kinney", Categoria.COMEDIA, 551));
        agregarLibro(new Libro("Sin noticias de Gurb", "Eduardo Mendoza", Categoria.COMEDIA, 552));
    }

    public GestorLibro() {
        libros = new Libro[MAX];
        cantidad = 0;
    }

    public boolean agregarLibro(Libro libro) {
        boolean respuesta = false;
        if (cantidad < MAX) {
            libros[cantidad] = libro;
            cantidad++;
            respuesta = true;
        }

        return respuesta;
    }

    public Libro buscarLibroTitulo(String titulo) {
        for (int i = 0; i < cantidad; i++) {
            if (libros[i].getTitulo().equals(titulo)) {
                return libros[i];
            }
        }

        return null;
    }

    public int buscarLibroISBN(int isbn) {
        for (int i = 0; i < cantidad; i++) {
            if (libros[i].getIsbn() == isbn) {
                return i;
            }
        }

        return -1;
    }

    public Libro[] buscarLibroAutor(String autor) {
        Libro[] librosAutores = new Libro[MAX];
        int j = 0;
        for (int i = 0; i < cantidad; i++) {
            if (libros[i].getAutor().equals(autor)) {
                librosAutores[j] = libros[i];
                j++;
            }
        }
        return Arrays.copyOf(librosAutores, j);
    }

    public Libro[] buscarLibroCategoria(Categoria categoria) {
        Libro[] librosCategorias = new Libro[MAX];
        int j = 0;
        for (int i = 0; i < cantidad; i++) {
            if (libros[i].getCategoria().equals(categoria)) {
                librosCategorias[j] = libros[i];
                j++;
            }
        }
        return Arrays.copyOf(librosCategorias, j);
    }

    public boolean eliminarLibro(int isbn) {
        int posicion = buscarLibroISBN(isbn);
        boolean respuesta = false;

        if (posicion != -1) {
            for (int i = posicion + 1; i < cantidad; i++) {
                libros[i - 1] = libros[i];
            }
            cantidad--;
            respuesta = true;
        }

        return respuesta;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void mostrarLibros() {
        System.out.println("\n LISTA DE LIBROS ");
        if (cantidad == 0) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println(libros[i]);
        }
    }

}
