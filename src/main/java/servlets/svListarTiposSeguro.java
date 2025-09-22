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
import dominio.TipoSeguro;

@WebServlet("/svListarTiposSeguro")
public class svListarTiposSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SeguroDAO segurosbd =  new SeguroDAO();
    public svListarTiposSeguro() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			ArrayList<TipoSeguro> tipos = segurosbd.cargarDdlSeguros();
			request.setAttribute("tipoSeguros", tipos);
			RequestDispatcher rd;
			String parametro = request.getParameter("parametro");
			switch(parametro) {
				case "Agregar":
				    int nuevaID = segurosbd.obtenerUltimoIdSeguro() + 1;
				    request.setAttribute("NuevaID", nuevaID);
					rd = request.getRequestDispatcher("AgregarSeguro.jsp");
					break;
				case "Listar":
					rd = request.getRequestDispatcher("ListarSeguros.jsp");
					break;
				case null:
					rd = request.getRequestDispatcher("ListarSeguros.jsp");
					break;
				default:
					rd = null;				
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
