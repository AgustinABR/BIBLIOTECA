public class Libro {

    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";

    private String titulo;
    private String autor;
    private Categoria categoria;
    private int isbn;
    private boolean disponible;

    public Libro(String titulo, String autor, Categoria categoria, int isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.isbn = isbn;
        disponible = true;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        String estado;
        if (disponible) {
            estado = VERDE + "Disponible" + RESET;
        } else {
            estado = ROJO + "Prestado" + RESET;
        }

        return "Título: " + titulo +
                " | Autor: " + autor +
                " | ISBN: " + isbn +
                " | Categoría: " + categoria +
                " | Estado: " + estado;
    }
}
