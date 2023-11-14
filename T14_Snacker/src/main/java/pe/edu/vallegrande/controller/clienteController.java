package pe.edu.vallegrande.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.vallegrande.app.dao.ClienteDAO;
import pe.edu.vallegrande.app.models.Cliente;

@WebServlet("/clienteController")
public class clienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDao;

	public void init() {
		clienteDao = new ClienteDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "/show":
			showCustomer(request, response);
			break;
		case "/new":
			showNewForm(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/delete":
			deleteCustomer(request, response);
			break;
		default:
			listCustomers(request, response);
		}
	}

	private void listCustomers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hla");
		List<Cliente> listUser = clienteDao.getAllCustomers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerList.jsp");
		dispatcher.forward(request, response);
	}

	private void showCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = clienteDao.getCustomerById(id);
		request.setAttribute("cliente", cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cliente update = clienteDao.getCustomerById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
		request.setAttribute("update", update);
		dispatcher.forward(request, response);
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		clienteDao.deleteCliente(id);
		response.sendRedirect("CustomerServlet?action=list");
	}

}
