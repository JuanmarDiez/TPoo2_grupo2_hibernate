package test;

import negocio.UsuarioAbm;

public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UsuarioAbm.getInstance().eliminar(7);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
