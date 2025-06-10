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
			List<Turno> aux;
			//--------Baja de la clase turno: Caso de uso 2------------
			
			TurnoAbm.getInstance().eliminarTurnoYDetalle(4);
			
			//--------Traer todos los turnos: Caso de uso 5------------
			System.out.println("----------------------Todos los turnos:CASO DE USO 5-----------");
			aux= TurnoAbm.getInstance().traer();
			TurnoAbm.getInstance().mostrarListaTurnos(aux);
			
			//--------Traer todos los turnos que pertenezcan a un intervalo de fechas: Caso de uso 8-----------
			System.out.println("----------------------Todos los turnos en cierto intervalo:CASO DE USO 8-----------");
			aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9));
																	
			
			TurnoAbm.getInstance().mostrarListaTurnos(aux);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
