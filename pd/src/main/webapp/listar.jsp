<%--
  Created by IntelliJ IDEA.
  User: Luis
  Date: 15/05/2019
  Time: 5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Listar</title>
</head>
<center><h1>Lista de Datos</h1></center>
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
        <td><input type="submit" name="action" value="listar1"></td>

        <td><input type="button" onclick=" location.href='index.jsp' " value="Regresar" name="boton" /></td>

    </div>
</form>
</body>
</html>
