public class GestorUsuario {
    private Usuario[] usuarios;
    private static final int MAX = 100;
    private int cantidad;

    public GestorUsuario() {
        usuarios = new Usuario[MAX];
        cantidad = 0;
    }

    public boolean registrarUsuario(Usuario usuario) {
        boolean respuesta = false;
        if (cantidad < MAX) {
            usuarios[cantidad] = usuario;
            cantidad++;
            respuesta = true;
        }

        return respuesta;
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (usuarios[i].getNombre().equals(nombre)) {
                return usuarios[i];
            }
        }
        return null;
    }

    public void consultarUsuario() {
        for (int i = 0; i < cantidad; i++) {
            System.out.println(usuarios[i].toString());
        }
    }
}
