<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
</head>
<body>
	<div>		
		<form:form action="/producto/modificar" method="post" modelAttribute="producto">
			<input type="hidden" name="_method" value="put" >
			<form:hidden path="id" />
			
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="precio">Precio:</form:label>
			<form:input type="text" path="precio"/><br>
			
			<form:label path="cantidad">Cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br>
			
			<input  type="submit" value="Modificar Producto">
		</form:form>
	</div>
</body>
</html>