package test;

import java.time.LocalDate;
import java.util.List;

import datos.Turno;
import negocio.LugarAbm;
import negocio.TurnoAbm;
import negocio.UsuarioAbm;

public class TestLugar {
	public static void main(String[] args) {
		try {
			//--------Baja de la clase servicio: Caso de uso 3------------
			LugarAbm.getInstance().eliminar(2);
			
			List<Turno> aux;
			
			//--------Traer todos los turnos para cierto intervalo de fechas y lugar: Caso de uso 11
			System.out.println("----------------------Turnos por lugar e intervalo de fechas:CASO DE USO 11-----------");
			aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),LugarAbm.getInstance().traer(1));
			TurnoAbm.getInstance().mostrarListaTurnos(aux);
			
			//--------Traer todos los turnos que pertenezcan a un lugar: Caso de uso 13---------------------
			System.out.println("----------------------Turnos por lugar e intervalo de fechas:CASO DE USO 13-----------");
			aux =UsuarioAbm.getInstance().traerTurnos(LugarAbm.getInstance().traer(1));
			TurnoAbm.getInstance().mostrarListaTurnos(aux);
			//--------Traer todos los turnos que pertenezcan a un lugar en una fecha: Caso de uso 19---------------
			System.out.println("----------------------Turnos por lugar e intervalo de fechas:CASO DE USO 19-----------");
			aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),LugarAbm.getInstance().traer(1));
			TurnoAbm.getInstance().mostrarListaTurnos(aux);
			
		}catch(Exception e) {
			
		}
	}
}
