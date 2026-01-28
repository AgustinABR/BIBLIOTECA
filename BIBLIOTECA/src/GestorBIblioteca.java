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

    public void cargarDatos() {
        gestorUsuario.cargarUsuarios();
        gestorLibro.cargarLibros();
        cargarPrestamos();
    }

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

    public boolean registrarUsuario(String nombre, String password, boolean esAdmin) {
        Usuario usuario = new Usuario(nombre, password, esAdmin);
        return gestorUsuario.registrarUsuario(usuario);
    }

    public void mostrarUsuarios() {
        gestorUsuario.consultarUsuario();
    }

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

    public void mostrarNumeroPrestamos() {
        gestorPrestamo.mostrarNumeroPrestamos();
    }

    public void mostrarLibrosMasPrestados() {
        gestorPrestamo.mostrarLibrosMasPrestados();
    }

    public void mostrarUsuarioConMasPrestamosActivos() {
        gestorPrestamo.mostrarUsuarioConMasPrestamosActivos();
    }

    public void cargarPrestamos() {
        Usuario pepe = gestorUsuario.buscarUsuarioPorNombre("pepe");
        Usuario maria = gestorUsuario.buscarUsuarioPorNombre("maria");
        Usuario juan = gestorUsuario.buscarUsuarioPorNombre("juan");
        Usuario marta = gestorUsuario.buscarUsuarioPorNombre("marta");

        Libro hobbit = gestorLibro.getLibros()[gestorLibro.buscarLibroISBN(111)];
        Libro dune = gestorLibro.getLibros()[gestorLibro.buscarLibroISBN(222)];
        Libro it = gestorLibro.getLibros()[gestorLibro.buscarLibroISBN(331)];
        Libro juegosHambre = gestorLibro.getLibros()[gestorLibro.buscarLibroISBN(441)];

        prestarLibro(1, hobbit, pepe, "01/10/2025");
        prestarLibro(2, dune, maria, "05/10/2025");

        prestarLibro(3, it, juan, "10/09/2025");
        devolverLibro(3, "25/09/2025");

        prestarLibro(4, juegosHambre, marta, "02/10/2025");
    }

}
