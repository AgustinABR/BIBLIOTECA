import java.util.Arrays;

public class GestorLibro {
    private Libro[] libros;
    private static final int MAX = 100;
    private int cantidad;

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

    private int buscarLibroISBN(int isbn) {
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
            respuesta = true;
        }

        return respuesta;
    }
}
