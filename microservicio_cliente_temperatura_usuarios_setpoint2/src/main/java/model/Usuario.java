package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUsuario;

	private String email;

	private String nombre;

	private String password;

	//bi-directional many-to-one association to Temperatura
	@OneToMany(mappedBy="usuario")
	private List<Temperatura> temperaturas;
	
	public Usuario(int idUsuario, String email, String nombre, String password) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		
	}

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Temperatura> getTemperaturas() {
		return this.temperaturas;
	}

	public void setTemperaturas(List<Temperatura> temperaturas) {
		this.temperaturas = temperaturas;
	}

	public Temperatura addTemperatura(Temperatura temperatura) {
		getTemperaturas().add(temperatura);
		temperatura.setUsuario(this);

		return temperatura;
	}

	public Temperatura removeTemperatura(Temperatura temperatura) {
		getTemperaturas().remove(temperatura);
		temperatura.setUsuario(null);

		return temperatura;
	}

}