package dominio;

public class Seguros {
	
	private Integer idSeguro;
	private String descripcion;
	private Integer idTipo;
	private double costoContratacion;
	private double costoAsegurado;
	
	public Seguros() {
		
	}
	
	
	public Seguros(Integer idSeguro, String descripcion, Integer idTipo, double costoContratacion,
			double costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.idTipo = idTipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}
	
	public Integer getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(Integer idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public double getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public double getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(double costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
	

}
