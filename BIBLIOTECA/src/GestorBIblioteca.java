public class GestorBiblioteca {

    private GestorLibro gestorLibro;
    private GestorUsuario gestorUsuario;
    private GestorPrestamo gestorPrestamo;

    public GestorBiblioteca() {
        gestorLibro = new GestorLibro();
        gestorUsuario = new GestorUsuario();
        gestorPrestamo = new GestorPrestamo(100);
    }

    public GestorLibro getGestorLibro() {
        return gestorLibro;
    }

    public GestorUsuario getGestorUsuario() {
        return gestorUsuario;
    }

    // LIBROS

    public boolean agregarLibro(String titulo, String autor, Categoria categoria, int isbn) {
        Libro libro = new Libro(titulo, autor, categoria, isbn);
        return gestorLibro.agregarLibro(libro);
    }

    public Libro buscarLibroTitulo(String titulo) {
        return gestorLibro.buscarLibroTitulo(titulo);
    }

    public boolean eliminarLibro(int isbn) {
        return gestorLibro.eliminarLibro(isbn);
    }

    // USUARIOS

    public boolean registrarUsuario(String nombre, String password, boolean esAdmin) {
        Usuario usuario = new Usuario(nombre, password, esAdmin);
        return gestorUsuario.registrarUsuario(usuario);
    }

    public void mostrarUsuarios() {
        gestorUsuario.consultarUsuario();
    }

    // PRÉSTAMOS

    public boolean prestarLibro(int idPrestamo, Libro libro, Usuario usuario, String fechaPrestamo) {

        if (libro == null || usuario == null) {
            return false;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro ya está prestado.");
            return false;
        }

        libro.prestar();
        usuario.incrementarPrestamos();

        Prestamo prestamo = new Prestamo(
                true,
                null,
                fechaPrestamo,
                idPrestamo,
                libro,
                usuario);

        return gestorPrestamo.registrarPrestamo(prestamo);
    }

    public void devolverLibro(int idPrestamo, String fechaDevolucion) {
        gestorPrestamo.devolverLibro(idPrestamo, fechaDevolucion);
    }

    public void mostrarPrestamosActivos(Usuario usuario) {
        gestorPrestamo.mostrarPrestamosActivos(usuario);
    }

    public void mostrarLibros() {
        gestorLibro.mostrarLibros();
    }

}
