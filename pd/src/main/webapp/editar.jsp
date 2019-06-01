<%--
  Created by IntelliJ IDEA.
  User: Luis
  Date: 15/05/2019
  Time: 5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edicion de datos</title>
</head>
<center><h1>Edicion de Datos</h1>
    <h2>Ingrese el ID del elemento a editar</h2>
</center>
<body>
<form action="./servletController" method="post">
    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Id:</th>
                <td><input type="text" name="idB" size="45"></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="action" value="buscar">
                </td>
            </tr>

        </table>

        <table>
            <tr>
                <td><h5>Id:</h5></td>
                <td><input type="text" name="id" value="${persona.id}"></td></br>
                <td><h5>Nombre:</h5></td>
                <td><input type="text" name="nombre" value="${persona.nombre}"></td></br>
                <td><h5>Direccion:</h5></td>
                <td><input type="text" name="direccion" value="${persona.direccion}"></td></br>
                <td><h5>Identificacion:</h5></td>
                <td><input type="text" name="identificacion" value="${persona.identificacion}"></td></br>
                <td><h5>Fecha nacimiento:</h5></td>
                <td><input type="text" name="fechanacimiento" value="${persona.fechanacimiento}"></td></br>
            </tr>
            <center>
                <tr>
                    <td><input type="submit" name="action" value="editar"></td>
                </tr>
            </center>
        </table>


        <td><a href="index.jsp">Regresar</a></td>
    </div>
</form>
</body>
</html>