package datos;

import java.util.Set;

public class Cliente extends Usuario {
	private int nroCliente;
	private Set<Turno> turnos;
	
	public Cliente() {}

	public Cliente(String email, String contrasena, String nombre, String apellido, int dni,int nroCliente) {
		super(email, contrasena, nombre, apellido, dni);
		this.nroCliente = nroCliente;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		return "Cliente ["+ super.toString() +"nroCliente=" + nroCliente + "]";
	}
	
	
	
}
