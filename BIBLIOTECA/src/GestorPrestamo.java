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
}
