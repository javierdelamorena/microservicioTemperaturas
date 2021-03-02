package dto;

import java.time.LocalDate;

public class DtoTemperatura {
	
	private int temp1;

	private int humedad;
	 
	private String fecha;
	
	private int idUsuario;
	
	
	private LocalDate dia;
	
	
	
	

	public DtoTemperatura(int temp1, int humedad, int idUsuario, LocalDate dia) {
		super();
		this.temp1 = temp1;
		this.humedad = humedad;
		
		this.idUsuario = idUsuario;
		this.dia = dia;
	}

	public DtoTemperatura(int temp1, int humedad, String fecha,int idUsuario) {
		super();
		this.temp1 = temp1;
		this.humedad = humedad;
		this.fecha = fecha;
		this.idUsuario= idUsuario;
	}
	
	
	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public DtoTemperatura() {
		super();
	}
	

	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getTemp1() {
		return temp1;
	}

	public void setTemp1(int temp1) {
		this.temp1 = temp1;
	}

	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
