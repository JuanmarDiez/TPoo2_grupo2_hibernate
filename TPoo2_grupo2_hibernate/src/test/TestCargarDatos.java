package test;

import java.time.LocalDate;
import java.time.LocalTime;

import negocio.LugarAbm;
import negocio.ServicioAbm;
import negocio.TurnoAbm;
import negocio.UsuarioAbm;

public class TestCargarDatos {
	public static void main(String[] args) {
		try {
			//--------Alta de la clase usuario: Caso de uso 1----------
			UsuarioAbm.getInstance().agregarCliente("Messi@gmail.com", "Argentina", "Lionel", "Messi", 18122022);
			UsuarioAbm.getInstance().agregarCliente("Fulanito@gmail.com", "55555", "Cosme", "Fulanito", 77888999);
			UsuarioAbm.getInstance().agregarEmpleado("Rodrigo@gmail.com", "1234", "Rodrigo", "De paul", 55666444, LocalDate.of(2021, 6, 23));
			UsuarioAbm.getInstance().agregarEmpleado("Pedro@gmail.com", "9876", "Pedro", "Gomez", 44555654, LocalDate.of(2023, 8, 12));
			
			//--------Alta de la clase lugar: Caso de uso 3------------
			LugarAbm.getInstance().agregarLugar("29 de Septiembre 3901", "Lanus");
			LugarAbm.getInstance().agregarLugar("Rojas 221", "Lomas de zamora");
			
			//--------Alta de la clase servicio: Caso de uso 4----------
			ServicioAbm.getInstance().agregarServicio("DDPT", "Lic. Sistemas");
			ServicioAbm.getInstance().agregarServicio("Lavado autos", "Lavado autos");
			
			//--------Alta de la clase turno: Caso de uso 2------------
			TurnoAbm.getInstance().agregarTurnoYDetalle(1, 3, 1, 1, "Hablar con director del departamento", LocalDate.of(2025, 5, 8), LocalTime.of(11, 30), LocalTime.of(12, 0));
			TurnoAbm.getInstance().agregarTurnoYDetalle(2, 3, 1, 1, "Hablar con director del departamento", LocalDate.of(2025, 5, 9), LocalTime.of(10, 00), LocalTime.of(10, 30));
			TurnoAbm.getInstance().agregarTurnoYDetalle(1, 3, 1, 1, "Hablar con director del departamento", LocalDate.of(2025, 5, 12), LocalTime.of(10, 00), LocalTime.of(10, 30));
			TurnoAbm.getInstance().agregarTurnoYDetalle(1, 3, 1, 1, "Hablar con director del departamento", LocalDate.of(2025, 5, 15), LocalTime.of(12, 30), LocalTime.of(13, 00));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
