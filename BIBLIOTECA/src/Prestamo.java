public class Prestamo {
    private int idPrestamo;
    private Libro libro;
    private Usuario usuario;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean activo;

    public Prestamo(boolean activo, String fechaDevolucion, String fechaPrestamo, int idPrestamo, Libro libro,
            Usuario usuario) {
        this.activo = activo;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaPrestamo = fechaPrestamo;
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.usuario = usuario;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void devolver(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.activo = false;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", libro=" + libro.getTitulo() +
                ", usuario=" + usuario.getNombre() +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                ", activo=" + activo +
                '}';
    }

}
