<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dominio.TipoSeguro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Seguros</title>
</head>
<body>
<a href="Inicio.jsp">Inicio </a>   
<a href="svListarTiposSeguro?parametro=Agregar&tipoSeguro=0">Agregar Seguro</a> 
<a href="svListarTiposSeguro?parametro=Listar">Listar Seguros</a>

<form method="get" action="svListarTiposSeguro">
	ID: <%= request.getAttribute("NuevaID") %> <br>
    Descripción: <input type="text" name="txtDescripcion"> <br>

    <select name="tipoSeguro">
    <%
    	ArrayList<TipoSeguro> tipos = (ArrayList<TipoSeguro>) request.getAttribute("tipoSeguros");
        if (tipos != null) {
        	%>
        	<%
        	%>
        	<option value=0>Seleccionar</option>
        	<%
            for (TipoSeguro t : tipos) {
    %>
                <option value="<%= t.getIdTipo() %>"><%= t.getDescripcion() %></option>
    <%
            }
        }
    %>
    </select>
    <br>

    Costo Contratación: <input type="text" name="txtCostoContratacion"> <br>
    Costo Máximo Asegurado: <input type="text" name="txtCostoAsegurado"> <br>

    <input type="submit" value="Aceptar" name="btnAceptar">
</form>

</body>
</html>
