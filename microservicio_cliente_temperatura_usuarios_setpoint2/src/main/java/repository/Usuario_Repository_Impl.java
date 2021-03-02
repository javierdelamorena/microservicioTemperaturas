package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository

public class Usuario_Repository_Impl implements Usuario_Repository{
	
	@Autowired
	Usuario_Repository_Spring_Data_Jpa repository;

	@Override
	public void darDeAlta(Usuario usuario) {
		
		repository.save(usuario);
	}

	@Override
	public void darDeBaja(Usuario usuario) {

		repository.delete(usuario);
		
	}

	@Override
	public List<Usuario> todos() {
		
		try {
			
			return repository.todos();
			
		}catch(NullPointerException e) {
			
			e.printStackTrace();
			
		}
		return null;
		
	}

	

	

}
