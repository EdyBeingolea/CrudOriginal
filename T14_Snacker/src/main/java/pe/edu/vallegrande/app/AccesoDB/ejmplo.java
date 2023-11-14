package pe.edu.vallegrande.app.AccesoDB;

import java.util.List;

import pe.edu.vallegrande.app.dao.ClienteDAO;
import pe.edu.vallegrande.app.models.Cliente;

public class ejmplo {

	public static void main(String[] args) {
		
		try {
			ClienteDAO service = new ClienteDAO();
			List<Cliente> lista = service.getAllCustomers();

			System.out.println("Filas: " + lista.size());
			for (Cliente rec : lista) {
				System.out.println(rec.getId() + " - " + rec.getName());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
