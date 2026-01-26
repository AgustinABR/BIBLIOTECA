public class Usuario {
    private boolean esAdmin;
    private String nombre;
    private String password;
    private int prestamosActivos;

    public Usuario(String nombre, String password, boolean esAdmin) {
        this.nombre = nombre;
        this.password = password;
        this.esAdmin = esAdmin;
        prestamosActivos = 0;
    }

    public void incrementarPrestamos() {
        prestamosActivos++;
    }

    public void decrementarPrestamos() {
        if (prestamosActivos > 0) {
            prestamosActivos--;
        }
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrestamosActivos() {
        return prestamosActivos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " || Admin: " + esAdmin;
    }

}
