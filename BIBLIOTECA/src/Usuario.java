
public class Usuario {
    private String nombre;
    private String contrasena;
    private boolean admin;

    public Usuario(String nombre, String contrasena, boolean admin) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.admin = admin;
    }

    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }
    public boolean isAdmin() { return admin; }
}


