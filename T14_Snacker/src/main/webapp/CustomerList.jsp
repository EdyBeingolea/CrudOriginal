<%@page import="pe.edu.vallegrande.app.models.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.vallegrande.app.dao.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>

</head>
<body >


	<h2>Lista de Clientes</h2>


	<table>
		<thead>
			<tr>
				<th>Nombre</th>
			</tr>
		</thead>

		<tbody>
			<!--   for (Todo todo: todos) {  -->

			<c:forEach items="${listUser}" var="cliente">
				<tr>
					<td><c:out value="${cliente.name}" /></td>
					<td><a class="btn btn-primary" role="button"
						href="/clienteController?action=update&id=<c:out value="${cliente.id}"/>">Update</a></td>
				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>
	</table>

	<a href="clienteController?action=new">Agregar nuevo cliente</a>

	<!-- Agregar mensajes de depuración -->
	<p id="numeroClientes"></p>


</body>
</html>
