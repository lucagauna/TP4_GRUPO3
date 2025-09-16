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

/**
 * Servlet implementation class svAgregarSeguros
 */
@WebServlet("/svAgregarSeguros")
public class svAgregarSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SeguroDAO segurosbd =  new SeguroDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svAgregarSeguros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 
		 try {
			ArrayList<TipoSeguro> tipos = segurosbd.cargarDdlSeguros();
			request.setAttribute("tipoSeguros", tipos);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AgregarSeguro.jsp");
	        rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
