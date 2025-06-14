package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Turno;
import negocio.TurnoAbm;
import negocio.UsuarioAbm;

public class TestUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			
			//--------Baja de la clase usuario: Caso de uso 1-----------
			//UsuarioAbm.getInstance().eliminar(4);
			
			List<Turno> aux = new ArrayList<Turno>();
			
			//--------Traer todos los turnos para un cliente y servicio en especifico: caso de uso 6----------
			System.out.println("-------------------Turnos por cliente y servicio:CASO DE USO 6-----------");
			 aux= UsuarioAbm.getInstance().traerTurnosServicio(1, 1);
			 TurnoAbm.getInstance().mostrarListaTurnos(aux);
			 
			//--------Traer todos los turnos para un cliente en un lugar en especifico: Caso de uso 7----------
			 System.out.println("-------------------Turnos por cliente y lugar:CASO DE USO 7-----------");
			 aux= UsuarioAbm.getInstance().traerTurnosLugar(1, 1);
			 TurnoAbm.getInstance().mostrarListaTurnos(aux);
			 
			//--------Traer todos los turnos para cierto intervalo de fechas y cliente: Caso de uso 9----------
			 System.out.println("-------------------Turnos por cliente en un intervalo de fechas:CASO DE USO 9-----------");
			 aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerCliente(1));
			 TurnoAbm.getInstance().mostrarListaTurnos(aux);
			//--------Traer todos los turnos de un cliente: Caso de uso 14---------
			 System.out.println("-------------------Turnos por cliente:CASO DE USO 14-----------");
			 aux =UsuarioAbm.getInstance().traerTurnos(UsuarioAbm.getInstance().traerCliente(1));
			 TurnoAbm.getInstance().mostrarListaTurnos(aux);
			
			//--------Traer todos los turnos que pertenezcan a un empleado: Caso de uso 15----------
			 System.out.println("-------------------Turnos por empleado:CASO DE USO 15-----------");
			 aux =UsuarioAbm.getInstance().traerTurnos(UsuarioAbm.getInstance().traerEmpleado(1));
			 TurnoAbm.getInstance().mostrarListaTurnos(aux);
			//--------Traer todos los turnos que pertenezcan a un cliente en una fecha: Caso de uso 16---------------
			 System.out.println("-------------------Turnos por cliente en una fecha:CASO DE USO 16-----------");
			 aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerCliente(2));
			 TurnoAbm.getInstance().mostrarListaTurnos(aux);
			//--------Traer todos los turnos que pertenezcan a un empleado en una fecha: Caso de uso 18---------------
			 System.out.println("-------------------Turnos por empleado en una fecha:CASO DE USO 18-----------");
			 aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerEmpleado(1));
			 TurnoAbm.getInstance().mostrarListaTurnos(aux);
			//--------Traer todos los turnos que pertenezcan a un intervalo de fechas y un empleado: Caso de uso 20----------
			 System.out.println("-------------------Turnos por empleado en un intervalo de fechas:CASO DE USO 20-----------");
			 aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerEmpleado(1));
			 TurnoAbm.getInstance().mostrarListaTurnos(aux);
			
		}catch(Exception e) {
			
		}
		
	}

}
