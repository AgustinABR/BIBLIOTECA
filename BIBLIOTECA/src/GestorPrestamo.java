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
        boolean salir = false;
        for (int i = 0; i < cantidad && !salir; i++) {
            if (prestamos[i].getIdPrestamo() == idPrestamo && prestamos[i].isActivo()) {
                prestamos[i].devolver(fechaDevolucion);
                prestamos[i].getLibro().devolver();
                prestamos[i].getUsuario().decrementarPrestamos();
                System.out.println("Libro devuelto correctamente.");
                salir = true;
            }
        }
        if (!salir) {
            System.out.println("Préstamo no encontrado o ya devuelto.");
        }
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

    public void mostrarNumeroPrestamos() {
        int total = cantidad;
        int activos = 0;

        for (int i = 0; i < cantidad; i++) {
            if (prestamos[i].isActivo()) {
                activos++;
            }
        }

        System.out.println("Préstamos totales: " + total);
        System.out.println("Préstamos activos: " + activos);
    }

    public void mostrarLibrosMasPrestados() {
        Libro[] libros = new Libro[cantidad];
        int[] contador = new int[cantidad];
        int usados = 0;

        for (int i = 0; i < cantidad; i++) {
            Libro libroActual = prestamos[i].getLibro();
            int pos = -1;

            for (int j = 0; j < usados; j++) {
                if (libros[j].getIsbn() == libroActual.getIsbn()) {
                    pos = j;
                    break;
                }
            }

            if (pos == -1) {
                libros[usados] = libroActual;
                contador[usados] = 1;
                usados++;
            } else {
                contador[pos]++;
            }
        }

        System.out.println("\nLIBROS MÁS PRESTADOS");
        for (int i = 0; i < usados; i++) {
            System.out.println(libros[i].getTitulo() + " " + contador[i] + " préstamos");
        }
    }

    public void mostrarUsuarioConMasPrestamosActivos() {
        Usuario usuario = null;
        int max = 0;

        for (int i = 0; i < cantidad; i++) {
            if (prestamos[i].isActivo()) {
                Usuario u = prestamos[i].getUsuario();

                if (u.getPrestamosActivos() > max) {
                    max = u.getPrestamosActivos();
                    usuario = u;
                }
            }
        }

        if (usuario != null) {
            System.out.println("Usuario con más préstamos activos:");
            System.out.println(usuario.getNombre() + " → " + max + " préstamos");
        } else {
            System.out.println("No hay préstamos activos.");
        }
    }
    

}
