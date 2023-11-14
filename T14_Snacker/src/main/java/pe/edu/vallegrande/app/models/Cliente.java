package pe.edu.vallegrande.app.models;

public class Cliente {

	private int id;
	private String name;
	private String address;
	private String phone;
	private char status;

	public Cliente() {
	}

	public Cliente(int id, String name, String address, String phone, char status) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.status = status;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	

}
