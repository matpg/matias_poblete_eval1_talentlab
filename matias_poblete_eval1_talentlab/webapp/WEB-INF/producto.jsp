<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>
	<div>
		<form:form action="/producto/crear" method="post" modelAttribute="producto">			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="precio">precio:</form:label>
			<form:input type="text" path="precio"/><br>
			
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br>
			
			<input type="submit" value="Crear Producto">
		</form:form>
		<br>
		<h1>Lista Productos</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Precio $</th>
					<th>Cantidad</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${lista_productos}" >
				<tr>
					<td></td>
					<td><c:out value="${producto.nombre}" /> </td>
					<td><c:out value="${producto.precio}" /> </td>
					<td><c:out value="${producto.cantidad}" /> </td>
					<td>
						<a href="/producto/actualizar/${producto.id}">Editar</a>
						<form action="/producto/eliminar/${producto.id}" method="POST">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Eliminar">
						</form>
						
						<!-- <form action="/empleado/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${empleado.id}" />" >
							<input type="submit" value="Eliminar">
						</form> --!>
						<!-- se hace con HREF o con una FORM -->
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>