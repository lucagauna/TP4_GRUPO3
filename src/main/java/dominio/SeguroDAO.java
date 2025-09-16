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
					
			System.out.println("Seguro agregado correctamente." +"Filas agregadas: " + filas);
			
			
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
					
					
				
			System.out.println("Listado cargado correctamente");
			
			
		}
		
		return ltiposeguros;
	}
		
}
