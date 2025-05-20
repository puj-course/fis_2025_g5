package g5.ROPA;

public class User {

	private String nombre = null;
	private String tipo = "N";
	private String correo = "N";

    private static User instance;						//singleton

    // Constructor privado para evitar instanciación externa
    private User() {}

    // Método de acceso público (hilo seguro con synchronized opcional)
    public static User getInstance() {
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    instance = new User();
                }
            }
        }
        return instance;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String string) {
        this.tipo = string;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

