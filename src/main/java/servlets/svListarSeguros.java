package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.SeguroDAO;
import dominio.Seguro;
import dominio.TipoSeguro;

@WebServlet("/svListarSeguros")
public class svListarSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SeguroDAO segurosbd =  new SeguroDAO();
    public svListarSeguros() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		 try {
			
			String tipoSeguro = request.getParameter("tipoSeguro");
			int id;
			if(tipoSeguro != null) {
				id = Integer.parseInt(tipoSeguro);
			}else {
				id = 0;
			}
			ArrayList<Seguro> s = segurosbd.getSeguros(id);
			request.setAttribute("Seguros", s);
			ArrayList<TipoSeguro> tipos = segurosbd.cargarDdlSeguros();
			request.setAttribute("tipoSeguros", tipos);
			String parametro = request.getParameter("parametro");
			RequestDispatcher rd;
			switch(parametro) {
				case "Agregar":
					int cantidad = s.size();
					request.setAttribute("NuevaID", cantidad+1);
					rd = request.getRequestDispatcher("AgregarSeguro.jsp");
					break;
				case null:
					rd = request.getRequestDispatcher("svListarTiposSeguro");	
					break;
				default:
					rd = request.getRequestDispatcher("ListarSeguros.jsp");			
			}
	        rd.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
