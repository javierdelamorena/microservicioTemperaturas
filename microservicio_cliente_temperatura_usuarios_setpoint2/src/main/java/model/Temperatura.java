package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the temperatura database table.
 * 
 */
@Entity
@Table(name="temperatura")
@NamedQuery(name="Temperatura.findAll", query="SELECT t FROM Temperatura t")
public class Temperatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtemp;

	
	private LocalDate dia;

	
	private LocalDateTime fecha;

	private int humedad;

	private int temp1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario",referencedColumnName="idUsuario")
	private Usuario usuario;
	
	public Temperatura( int humedad, int temp1,LocalDate dia, LocalDateTime fecha,  Usuario usuario) {
		super();
		
		this.dia = dia;
		this.fecha = fecha;
		this.humedad = humedad;
		this.temp1 = temp1;
		this.usuario = usuario;
	}

	public Temperatura() {
	}

	public int getIdtemp() {
		return this.idtemp;
	}

	public void setIdtemp(int idtemp) {
		this.idtemp = idtemp;
	}

	public LocalDate getDia() {
		return this.dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalDateTime getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getHumedad() {
		return this.humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public int getTemp1() {
		return this.temp1;
	}

	public void setTemp1(int temp1) {
		this.temp1 = temp1;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}