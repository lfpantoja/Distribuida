<%--
  Created by IntelliJ IDEA.
  User: Luis
  Date: 15/05/2019
  Time: 7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ingreso de datos</title>
</head>
<center><h1>Ingreso de Datos</h1></center>
<body>
<form action="./servletController" method="post">
    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Id:</th>
                <td><input type="text" name="id" size="45"></td>
            </tr>
            <tr>
                <th>Nombre:</th>
                <td><input type="text" name="nombre" size="45"></td>
            </tr>
            <tr>
                <th>Direccion:</th>
                <td><input type="text" name="direccion" size="45"></td>
            </tr>
            <tr>
                <th>Identificacion:</th>
                <td><input type="text" name="identificacion" size="45"></td>
            </tr>
            <tr>
                <th>Fecha Nacimiento:</th>
                <td><input type="text" name="fechanacimiento" size="45"></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="action" value="guardar">
                </td>
            </tr>

        </table>
    </div>
</form>
</body>
</html>
