package g5.ROPA;

public class Tela {

    private final String nombre;
    private final String descripcion;
    private final int nota;
    private final String imagen;

    private Tela(Builder builder) {
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.nota = builder.nota;
        this.imagen = builder.imagen;
    }

    public static class Builder {
        private String nombre;
        private String descripcion;
        private int nota;
        private String imagen;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder nota(int nota) {
            this.nota = nota;
            return this;
        }

        public Builder imagen(String imagen) {
            this.imagen = imagen;
            return this;
        }

        public Tela build() {
            return new Tela(this);
        }
    }

    // Getters opcionales
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getNota() { return nota; }
    public String getImagen() { return imagen; }
}


/*public class Tela {
	
	private String nombre;
	private String descripcion;
	private int nota;
	private String imagen;
	
	
	
	public Tela(String nombre, String descripcion, int nota, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nota = nota;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getNota() {
		return nota;
	}
	
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Tela [nombre=" + nombre + ", descripcion=" + descripcion + ", nota=" + nota + ", imagen=" + imagen+ "]";
	}
	
	
}*/

