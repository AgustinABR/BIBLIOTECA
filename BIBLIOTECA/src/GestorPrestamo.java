public class GestorPrestamo {
    private Prestamo[] prestamos;
    private int totalPrestamos;

    public GestorPrestamo(int maxPrestamos) {
        prestamos = new Prestamo[maxPrestamos];
        totalPrestamos = 0;
    }

    public void registrarPrestamo(Prestamo prestamo) {
        prestamos[totalPrestamos++] = prestamo;
    }

    public void devolverLibro(int idPrestamo, String fechaDevolucion) {
        for (int i = 0; i < totalPrestamos; i++) {
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

        for (int i = 0; i < totalPrestamos; i++) {
            if (prestamos[i].isActivo()) {
                System.out.println(prestamos[i]);
            }
        }
    }
}
