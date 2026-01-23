public class GestorPrestamo {
    private Prestamo[] prestamos;
    private static final int MAX = 100;
    private int cantidad;

    public GestorPrestamo(int maxPrestamos) {
        prestamos = new Prestamo[maxPrestamos];
        cantidad = 0;
    }

    public boolean registrarPrestamo(Prestamo prestamo) {
        boolean respuesta = false; 
        if (cantidad < MAX) {
            prestamos[cantidad] = prestamo;
            cantidad++;
            respuesta = true;
        }
        
        return respuesta;
    }

    public void devolverLibro(int idPrestamo, String fechaDevolucion) {
        for (int i = 0; i < cantidad; i++) {
            if (prestamos[i].getIdPrestamo() == idPrestamo && prestamos[i].isActivo()) {
                prestamos[i].devolver(fechaDevolucion);
                prestamos[i].getLibro().devolver();
                prestamos[i].getUsuario().decrementarPrestamos();
                System.out.println("Libro devuelto correctamente.");
                return;
            }
        }
        System.out.println("Préstamo no encontrado o ya devuelto.");
    }

    public void mostrarPrestamosActivos(Usuario usuario) {
        if (!usuario.isEsAdmin()) {
            System.out.println("Acceso denegado. Solo administradores.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            if (prestamos[i].isActivo()) {
                System.out.println(prestamos[i]);
            }
        }
    }
}
