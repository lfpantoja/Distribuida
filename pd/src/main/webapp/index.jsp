<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luis
  Date: 15/05/2019
  Time: 5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>INICIO CRUD</title>
</head>
<body>

<center>
  <h1>CRUD</h1>
  <form action="./servletController" method="post">
    <h2>
      <td><input type="button" onclick=" location.href='ingreso.jsp' " value="Ingreso de Persona" name="boton" /></td>
    </h2>

    <table border="1">
      <td><input type="button" onclick=" location.href='editar.jsp' " value="Editar Persona" name="boton" /></td>
      <td><input type="button" onclick=" location.href='eliminar.jsp' " value="Eliminar Persona" name="boton" /></td>
      <td><input type="button" onclick=" location.href='listar.jsp' " value="Mostrar Persona" name="boton" /></td>
      </br></br></br>

    </table>
  </form>
</center>

</body>
</html>
