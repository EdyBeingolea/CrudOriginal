package pe.edu.vallegrande.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.vallegrande.app.AccesoDB.Conexion;
import pe.edu.vallegrande.app.models.Cliente;

public class ClienteDAO {

	
	public List<Cliente> getAllCustomers() {
		List<Cliente> cliente = new ArrayList<>();
		String query = "SELECT * FROM Customer";
		try (PreparedStatement pstm = Conexion.getConnection().prepareStatement(query); ResultSet rs = pstm.executeQuery()) {

			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setId(rs.getInt("id"));
				cli.setName(rs.getString("name"));
				cli.setAddress(rs.getString("address"));
				cli.setPhone(rs.getString("phone"));
				cli.setStatus(rs.getString("status").charAt(0));
				cliente.add(cli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al obtener clientes: " + e.getMessage());
		}
		return cliente;
	}

	public Cliente getCustomerById(int customerId) {

		Cliente cliente = null;
		String query = "SELECT * FROM Customer WHERE id = ?";

		try (PreparedStatement statement = Conexion.getConnection().prepareStatement(query)) {
			statement.setInt(1, customerId);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					cliente = new Cliente();
					cliente.setId(resultSet.getInt("id"));
					cliente.setName(resultSet.getString("name"));
					cliente.setAddress(resultSet.getString("address"));
					cliente.setPhone(resultSet.getString("phone"));
					cliente.setStatus(resultSet.getString("status").charAt(0));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public void addCliente(Cliente cliente) {

		String query = "INSERT INTO Customer (name, address, phone, status) VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = Conexion.getConnection().prepareStatement(query)) {
			statement.setString(1, cliente.getName());
			statement.setString(2, cliente.getAddress());
			statement.setString(3, cliente.getPhone());
			statement.setString(4, String.valueOf(cliente.getStatus()));

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomer(Cliente cliente) {

		String query = "UPDATE Customer SET name = ?, address = ?, phone = ?, status = ? WHERE id = ?";

		try (PreparedStatement statement = Conexion.getConnection().prepareStatement(query)) {
			statement.setString(1, cliente.getName());
			statement.setString(2, cliente.getAddress());
			statement.setString(3, cliente.getPhone());
			statement.setString(4, String.valueOf(cliente.getStatus()));
			statement.setInt(5, cliente.getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCliente(int id) {

		String query = "UPDATE Customer SET status = 'I' WHERE id = ?";

		try (PreparedStatement statement = Conexion.getConnection().prepareStatement(query)) {
			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(); //
		}
	}

}
