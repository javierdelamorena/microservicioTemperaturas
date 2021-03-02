package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Usuario;

public interface Usuario_Repository_Spring_Data_Jpa extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u")
	List<Usuario> todos();

	
	
}
