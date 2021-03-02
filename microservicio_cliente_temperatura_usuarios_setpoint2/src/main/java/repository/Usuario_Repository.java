package repository;

import java.util.List;

import model.Usuario;

public interface Usuario_Repository {
	
	void darDeAlta(Usuario usuario);
	void darDeBaja(Usuario usuario);
	List<Usuario> todos();
	
	
	
}
