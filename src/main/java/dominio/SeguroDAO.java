package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class SeguroDAO {
	

	
	public Connection getConnection() throws SQLException {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");  // fuerza a cargar el driver
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return DriverManager.getConnection(
	        "jdbc:mysql://localhost:3306/segurosgroup?useSSL=false&serverTimezone=UTC",
	        "root",
	        "root"
	    );
	}
	
		
	public int AgregarSeguro (Seguro seguro) {
		int filas = 0;
		String query = "INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES (?,?,?,?)";
		try (Connection cn = getConnection();
				PreparedStatement st = cn.prepareStatement(query)){
				
					st.setString(1,seguro.getDescripcion());
					st.setInt(2,seguro.getIdTipo());
					st.setDouble(3,seguro.getCostoContratacion());
					st.setDouble(4,seguro.getCostoAsegurado());
					
					filas = st.executeUpdate();		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
	
//	public int ListarSeguros (Seguro seguro) {
//		int filas = 0;
//		
//		
//		return filas;
//	}
	
	public ArrayList<TipoSeguro> cargarDdlSeguros() throws SQLException{
		
		String query = "SELECT * FROM tiposeguros ";
		 ArrayList<TipoSeguro> ltiposeguros = new ArrayList<>();
		try (Connection cn =  getConnection();
				PreparedStatement st = cn.prepareStatement(query)){
			ResultSet rs = st.executeQuery();
			  while (rs.next()) {
				  System.out.println("Fila -> idTipo: " + rs.getInt("idTipo") + " | desc: " + rs.getString("descripcion"));
	               TipoSeguro ts = new TipoSeguro();
	                ts.setIdTipo(rs.getInt("idTipo"));
	                ts.setDescripcion(rs.getString("descripcion"));
	                ltiposeguros.add(ts);
	            }
		}
		return ltiposeguros;
	}
	
	public ArrayList<Seguro> getSeguros(int id) throws SQLException {
	    ArrayList<Seguro> seguros = new ArrayList<>();
	    String query;
	    if (id == 0) {
	        query = "SELECT * FROM seguros";
	    } else {
	        query = "SELECT * FROM seguros WHERE idTipo = ?";
	    }

	    try (Connection cn = getConnection();
	         PreparedStatement st = cn.prepareStatement(query)) {
	        if (id > 0) {
	            st.setInt(1, id);
	        }

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                Seguro s = new Seguro();
	                s.setIdSeguro(rs.getInt("idSeguro"));
	                s.setDescripcion(rs.getString("descripcion"));
	                s.setIdTipo(rs.getInt("idTipo"));
	                s.setCostoContratacion(rs.getDouble("costoContratacion"));
	                s.setCostoAsegurado(rs.getDouble("costoAsegurado"));
	                seguros.add(s);
	            }
	        }
	    }

	    return seguros;
	}

}

