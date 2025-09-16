package dominio;

public class TipoSeguro {

	
	private Integer idTipo;
	private String descripcion;
	
	
	
	public TipoSeguro() {
		
	}
	
	public TipoSeguro(Integer idTipo, String descripcion) {
		super();
		this.idTipo = idTipo;
		this.descripcion = descripcion;
	}
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
