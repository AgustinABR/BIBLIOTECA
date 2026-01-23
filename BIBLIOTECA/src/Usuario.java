public class Usuario {
    private boolean esAdmin;
    private String nombre;
    private String password;

    public Usuario(String nombre, String password, boolean esAdmin) {
        this.nombre = nombre;
        this.password = password;
        this.esAdmin = esAdmin;
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






}
