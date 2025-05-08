package datos;


public class Usuario {
	protected long idUsuario;
	protected String email;
	protected String contrasena;
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected String tipo;
	
	public Usuario() {}

	public Usuario(String email, String contrasena, String nombre, String apellido, int dni,String tipo) {
		super();
		this.email = email;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tipo = tipo;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) throws Exception {
		this.dni = dni;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "idUsuario=" + idUsuario + ", email=" + email + ", contrasena=" + contrasena + ", nombre="
				+ nombre + ", apellido=" + apellido + ", dni=" + dni ;
	}
	
	
	
}
