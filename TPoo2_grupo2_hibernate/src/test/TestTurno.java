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
			
			//					------------------------------------ALTAS----------------------------
			//--------Alta de la clase usuario: Caso de uso 1----------
			//UsuarioAbm.getInstance().agregarCliente("Messi@gmail.com", "Argentina", "Lionel", "Messi", 18122023);
			//UsuarioAbm.getInstance().agregarEmpleado("Rodrigo@gmail.com", "1234", "Rodrigo", "De paul", 55666444, LocalDate.of(2021, 6, 23));
						
			//--------Alta de la clase lugar: Caso de uso 3------------
			//LugarAbm.getInstance().agregarLugar("29 de Septiembre 3901", "Lanus");

						
			//--------Alta de la clase servicio: Caso de uso 4----------
			//ServicioAbm.getInstance().agregarServicio("DDPT", "Lic. Sistemas");

			//--------Alta de la clase turno: Caso de uso 2------------
			//TurnoAbm.getInstance().agregarTurnoYDetalle(20, 16, 5, 5, "Hablar con director del departamento", LocalDate.of(2025, 5, 8), LocalTime.of(11, 30), LocalTime.of(12, 0));
			
			
			
			// ----------------------------------------------BAJAS---------------------------------------------------------
			//--------Baja de la clase usuario: Caso de uso 1-----------
			//UsuarioAbm.getInstance().agregarCliente("Fulanito@gmail.com", "55555", "Cosme", "Fulanito", 77888999);
			//UsuarioAbm.getInstance().eliminar(17);
			
			//--------Baja de la clase lugar: Caso de uso 3------------
			//LugarAbm.getInstance().agregarLugar("Rojas 221", "Lomas de zamora");
			//LugarAbm.getInstance().eliminar(3);
			
			//--------Baja de la clase servicio:Caso de uso 4----------
			//ServicioAbm.getInstance().agregarServicio("Lavado autos", "Lavado autos");
			//ServicioAbm.getInstance().eliminar(3);
			
			
			//--------Baja de la clase turno: Caso de uso 2------------
			//TurnoAbm.getInstance().agregarTurnoYDetalle(20, 16, 5, 5, "Hablar con director del departamento", LocalDate.of(2025, 5, 9), LocalTime.of(10, 00), LocalTime.of(10, 30));
			//TurnoAbm.getInstance().eliminarTurnoYDetalle(7);
			
			
			
			//-------------------------------------------------------CONSULTAS----------------------------------------------------------------
			//--------Traer todos los turnos: Caso de uso 5------------
			//List<Turno> aux= TurnoAbm.getInstance().traer();
	
			
			//--------Traer todos los turnos para un cliente y servicio en especifico: caso de uso 6----------
			//List<Turno> aux= UsuarioAbm.getInstance().traerTurnosServicio(1, 4);
			
			
			//--------Traer todos los turnos para un cliente en un lugar en especifico: Caso de uso 7----------
			//List<Turno> aux= UsuarioAbm.getInstance().traerTurnosLugar(1, 4);
	
			
			//--------Traer todos los turnos que pertenezcan a un intervalo de fechas: Caso de uso 8-----------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9));
	
			
			//--------Traer todos los turnos para cierto intervalo de fechas y cliente: Caso de uso 9----------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerCliente(1));

	
			//--------Traer todos los turnos para cierto intervalo de fechas y servicio: Caso de uso 10
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),ServicioAbm.getInstance().traer(4));
		
			
			//--------Traer todos los turnos para cierto intervalo de fechas y lugar: Caso de uso 11
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),LugarAbm.getInstance().traer(4));
			
			
			//--------Traer todos los turnos que pertenezcan a un servicio:Caso de uso 12--------------------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(ServicioAbm.getInstance().traer(4));
			
			
			//--------Traer todos los turnos que pertenezcan a un lugar: Caso de uso 13---------------------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LugarAbm.getInstance().traer(3));
			
			
			//--------Traer todos los turnos de un cliente: Caso de uso 14---------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(UsuarioAbm.getInstance().traerCliente(1));
			
			
			//--------Traer todos los turnos que pertenezcan a un empleado: Caso de uso 15----------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(UsuarioAbm.getInstance().traerEmpleado(1));
			
			
			//--------Traer todos los turnos que pertenezcan a un cliente en una fecha: Caso de uso 16---------------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerCliente(4));
			
			
			//--------Traer todos los turnos que pertenezcan a un servicio en una fecha: Caso de uso 17---------------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),ServicioAbm.getInstance().traer(4));
			
			
			//--------Traer todos los turnos que pertenezcan a un empleado en una fecha: Caso de uso 18---------------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerEmpleado(3));
			
			
			//--------Traer todos los turnos que pertenezcan a un lugar en una fecha: Caso de uso 19---------------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 9),LugarAbm.getInstance().traer(4));
			
			
			//--------Traer todos los turnos que pertenezcan a un intervalo de fechas y un empleado: Caso de uso 20----------
			//List<Turno> aux =UsuarioAbm.getInstance().traerTurnos(LocalDate.of(2025, 5, 6),LocalDate.of(2025, 5, 9),UsuarioAbm.getInstance().traerEmpleado(2));
			
			
	
			
			
			//TurnoAbm.getInstance().mostrarListaTurnos(aux);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
