package g5.ROPA;

// Clase User que implementa el patrón Singleton para asegurar que solo exista una única instancia.
// Representa un usuario con atributos básicos como nombre, tipo y correo.
public class User {

	private String nombre = null;
	private String tipo = "N";
	private String correo = "N";

    // Instancia única de la clase (Singleton)
    private static User instance;

    // Constructor privado para evitar la creación de instancias externas
    private User() {}

    // Método público para obtener la instancia única de la clase.
    // Utiliza doble verificación con synchronized para ser seguro en entornos multihilo.
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

    // Métodos getter y setter para acceder y modificar los atributos de la clase
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
