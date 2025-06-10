package test;


import java.time.LocalDate;
import java.util.List;

import datos.Turno;
import negocio.ServicioAbm;
import negocio.TurnoAbm;
import negocio.UsuarioAbm;

public class TestServicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//--------Baja de la clase servicio: Caso de uso 4------------
			ServicioAbm.getInstance().eliminar(2);
			
			List<Turno> aux;
			
			//--------Traer todos los turnos para cierto intervalo de fechas y servicio: Caso de uso 10
			System.out.println("Turno por servicio e intervalo de fechas: CASO DE USO 10");
			aux = UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),ServicioAbm.getInstance().traer(1));	
			TurnoAbm.getInstance().mostrarListaTurnos(aux);
			//--------Traer todos los turnos que pertenezcan a un servicio:Caso de uso 12--------------------
			System.out.println("Turno por servicio e intervalo de fechas: CASO DE USO 12");
			aux =UsuarioAbm.getInstance().traerTurnos(ServicioAbm.getInstance().traer(1));
			TurnoAbm.getInstance().mostrarListaTurnos(aux);
			//--------Traer todos los turnos que pertenezcan a un servicio en una fecha: Caso de uso 17---------------
			System.out.println("Turno por servicio e intervalo de fechas: CASO DE USO 17");
			aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),ServicioAbm.getInstance().traer(1));
			TurnoAbm.getInstance().mostrarListaTurnos(aux);
		}catch(Exception e) {
			
		}
	}

}
