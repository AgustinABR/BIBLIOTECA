public class Libro {
    private String titulo;
    private String autor;
    private String categoria;
    private int isbn;

    public Libro(String titulo, String autor, String categoria, int isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.isbn = isbn;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    public int getIsbn() {
        return isbn;
    }



    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }


}
