package g5.ROPA;

public class Emprendimiento {

    private final String nombre;
    private final String descripcion;
    private final String pagina;
    private final String imagen;
    private final String correo;

    private Emprendimiento(Builder builder) {
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.pagina = builder.pagina;
        this.imagen = builder.imagen;
        this.correo = builder.correo;
    }

    public static class Builder {
        private String nombre;
        private String descripcion;
        private String pagina;
        private String imagen;
        private String correo;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder pagina(String pagina) {
            this.pagina = pagina;
            return this;
        }

        public Builder imagen(String imagen) {
            this.imagen = imagen;
            return this;
        }

        public Builder correo(String correo) {
            this.correo = correo;
            return this;
        }

        public Emprendimiento build() {
            return new Emprendimiento(this);
        }
    }

    // Getters opcionales
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getPagina() { return pagina; }
    public String getImagen() { return imagen; }
    public String getCorreo() { return correo; }
}



/*public class Emprendimiento {
	
	private String nombre;
	private String descripcion;
	private String pagina;
	private String imagen;
	private String correo;
	
	public Emprendimiento(String nombre, String descripcion, String pagina, String imagen, String correo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pagina = pagina;
		this.imagen = imagen;
		this.correo = correo;
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
	
	public String getPagina() {
		return pagina;
	}
	
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	@Override
	public String toString() {
		return "Emprendimiento [nombre=" + nombre + ", descripcion=" + descripcion + ", pagina=" + pagina + ", imagen="
				+ imagen + ", correo=" + correo + "]";
	}
	
	
	
}*/

	
	
}*/
