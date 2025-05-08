package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import datos.Cliente;
import datos.Empleado;
import datos.Turno;
import datos.Usuario;
import negocio.DetalleTurnoAbm;
import negocio.LugarAbm;
import negocio.ServicioAbm;
import negocio.TurnoAbm;
import negocio.UsuarioAbm;


public class TestTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			//UsuarioAbm.getInstance().agregarCliente("Messi@gmail.com", "Argentina", "Lionel", "Messi", 18122023);
			//UsuarioAbm.getInstance().agregarEmpleado("Rodrigo@gmail.com", "1234", "Rodrigo", "De paul", 55666444, LocalDate.of(2021, 6, 23));
			//LugarAbm.getInstance().agregarLugar("29 de Septiembre 3901", "Lanus");
			//ServicioAbm.getInstance().agregarServicio("DDPT", "Lic. Sistemas");
			
			//UsuarioAbm.getInstance().agregarCliente("Fulanito@gmail.com", "55555", "Cosme", "Fulanito", 77888999);
			//UsuarioAbm.getInstance().eliminar(17);
			//LugarAbm.getInstance().eliminar(3);
			//ServicioAbm.getInstance().eliminar(3);
			
			//TurnoAbm.getInstance().agregarTurnoYDetalle(20, 16, 5, 5, "Hablar con director del departamento", LocalDate.of(2025, 5, 8), LocalTime.of(11, 30), LocalTime.of(12, 0));
			
			
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(UsuarioAbm.getInstance().traerCliente(1));
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(UsuarioAbm.getInstance().traerEmpleado(1));
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LugarAbm.getInstance().traer(3));
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(ServicioAbm.getInstance().traer(4));
			
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnosLugar(1,3);
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnosServicio(2,4);
			
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9));
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerEmpleado(2));
			
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),ServicioAbm.getInstance().traer(4));
	
			
			
			//TurnoAbm.getInstance().mostrarListaTurnos(aux);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
