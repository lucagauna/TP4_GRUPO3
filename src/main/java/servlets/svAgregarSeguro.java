package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDAO;

@WebServlet("/svAgregarSeguro")
public class svAgregarSeguro extends HttpServlet {
    private static final long serialVersionUID = 1L;
    SeguroDAO dao = new SeguroDAO();

    public svAgregarSeguro() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String descripcion = request.getParameter("txtDescripcion");
            int idTipo = Integer.parseInt(request.getParameter("tipoSeguro"));
            double costoContratacion = Double.parseDouble(request.getParameter("txtCostoContratacion"));
            double costoAsegurado = Double.parseDouble(request.getParameter("txtCostoAsegurado"));

            Seguro nuevo = new Seguro();
            nuevo.setDescripcion(descripcion);
            nuevo.setIdTipo(idTipo);
            nuevo.setCostoContratacion(costoContratacion);
            nuevo.setCostoAsegurado(costoAsegurado);

            int filas = dao.AgregarSeguro(nuevo);

            if (filas > 0) {
                response.sendRedirect("svListarSeguros?parametro=Listar");
            } else {
                response.getWriter().write("Error: no se pudo insertar el seguro");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("AgregarSeguro.jsp");
    }
}