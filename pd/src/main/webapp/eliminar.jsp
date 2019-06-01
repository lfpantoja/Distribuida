<%--
  Created by IntelliJ IDEA.
  User: Luis
  Date: 15/05/2019
  Time: 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Eliminacion de datos</title>
</head>
<center><h1>Eliminacion de Datos</h1>
    <h2>Ingrese el ID del elemento a eliminar</h2>
</center>
<body>
<form action="./servletController" method="post">
    <div align="center">
        <caption>
            <h2>Lista de Personas</h2>
        </caption>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Direccion</th>
                <th>Identificacion</th>
                <th>Fecha Nacimiento</th>
            </tr>

            <c:forEach var="persona" items="${listaPersona}">
                <tr>
                    <td><c:out value="${persona.id}" /></td>
                    <td><c:out value="${persona.nombre}" /></td>
                    <td><c:out value="${persona.direccion}" /></td>
                    <td><c:out value="${persona.identificacion}" /></td>
                    <td><c:out value="${persona.fechanacimiento}" /></td>
                </tr>
            </c:forEach>
        </table>
        <td><input type="submit" name="action" value="listar2"></td>

        <table border="1" cellpadding="5">
            <tr>
                <th>Id:</th>
                <td><input type="text" name="id" size="45"></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="action" value="borrar">
                </td>
            </tr>

        </table>
        <td><input type="button" onclick=" location.href='index.jsp' " value="Regresar" name="boton" /></td>
    </div>
</form>
</body>
</html>
