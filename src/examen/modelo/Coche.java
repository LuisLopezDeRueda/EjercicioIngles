package examen.modelo;

import java.time.LocalDate;

public class Coche {

	private String marca;
	private String modelo;
	private LocalDate fechaUltimaRevision;
	private Integer antiguedad;
	
	
	public Coche(String marca, String modelo, LocalDate fechaUltimaRevision, Integer antiguedad) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.fechaUltimaRevision = fechaUltimaRevision;
		this.antiguedad = antiguedad;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public LocalDate getFechaUltimaRevision() {
		return fechaUltimaRevision;
	}
	public void setFechaUltimaRevision(LocalDate fechaUltimaRevision) {
		this.fechaUltimaRevision = fechaUltimaRevision;
	}
	public Integer getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	
	

}
