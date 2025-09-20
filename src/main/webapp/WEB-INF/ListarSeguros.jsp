<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dominio.Seguro" %>
<%@ page import="dominio.TipoSeguro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Seguros</title>
</head>
<body>
<a href="Inicio.jsp">Inicio </a>
<a href="AgregarSeguro.jsp">Agregar Seguro</a>
<a href="ListarSeguros.jsp">Listar Seguros</a>

<form method="get" action="svListarSeguros">

<h1>"Tipo de seguros en la base de datos"</h1>

Busqueda por tipo de seguros: 

    <%
    ArrayList<Seguro> seguros = (ArrayList<Seguro>) request.getAttribute("Seguros");
    %>

	<form method="get" action=svListarTiposSeguro>
    <%
    	
    ArrayList<TipoSeguro> tipos = (ArrayList<TipoSeguro>) request.getAttribute("tipoSeguros");

        
    %>

    <select name="tipoSeguro">
    <%
        if (tipos != null) {
            for (TipoSeguro t : tipos) {
    %>
                <option value="<%= t.getIdTipo() %>"><%= t.getDescripcion() %></option>
    <%
            }
        }
    %>
    </select>
    </form>
    <input type="submit" value="Filtrar" name="Filtrado">
    
    <br>
    <br>
    
    
    <table border="1">
    <tr>
    <th> ID Seguro</th>
    <th>Descripción Seguro</th> 
    <th>Desripción Tipo Seguro</th> 
    <th> Costo Contratación</th>
    <th>Costo Máximo Asegurado</th> 
    </tr>
    <%if (seguros != null) {
        for (Seguro s : seguros) {
    %>
    <tr>
	    <td><%= s.getIdSeguro() %> </td>
	    <td><%= s.getDescripcion() %></td>
	    <td><%= s.getIdTipo() %></td>
	    <td><%= s.getCostoContratacion() %></td> 
	    <td><%= s.getCostoAsegurado() %></td> 
    </tr>
    <%
        }
        }
        %>
    		
</form>

</body>
</html>