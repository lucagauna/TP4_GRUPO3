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
<a href="svListarTiposSeguro?parametro=Agregar">Agregar Seguro</a> 
<a href="svListarTiposSeguro?parametro=Listar">Listar Seguros</a>

<h1>"Tipo de seguros en la base de datos"</h1>

<form method="get" action="svListarSeguros">

Busqueda por tipo de seguros: 

    <select name="tipoSeguro">
    <%
        ArrayList<TipoSeguro> tipos = (ArrayList<TipoSeguro>) request.getAttribute("tipoSeguros");
        int seleccionado = 0;
        if (request.getParameter("tipoSeguro") != null) {
            seleccionado = Integer.parseInt(request.getParameter("tipoSeguro").toString());
        }
        if (tipos != null) {
    %>
        <option value="0">Seleccionar</option>
    <%
            for (TipoSeguro t : tipos) {
    %>
                <option value="<%= t.getIdTipo() %>"
                    <%= (t.getIdTipo() == seleccionado) ? "selected" : "" %>>
                    <%= t.getDescripcion() %>
                </option>
    <%
            }
        }
    %>
</select>

    
    <input type="submit" value="Filtrar" name="Filtrado">
    
    </form>
    
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
    <%
    ArrayList<Seguro> seguros = (ArrayList<Seguro>) request.getAttribute("Seguros");
    if (seguros != null) {
        for (Seguro s : seguros) {
    %>
    <tr>
	    <td><%= s.getIdSeguro() %> </td>
	    <td><%= s.getDescripcion() %></td>
	    <td>
		<%
    		for (TipoSeguro t : tipos) {
        		if (t.getIdTipo().equals(s.getIdTipo())) {
            		out.print(t.getDescripcion());
            		break;
        		}
    		}
		%>
		</td>
	    <td><%= s.getCostoContratacion() %></td> 
	    <td><%= s.getCostoAsegurado() %></td> 
    </tr>
    <%
        }
    }
    %>
</table>

</body>
</html>