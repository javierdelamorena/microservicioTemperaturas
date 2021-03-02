package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DtoUsuario;
import model.Usuario;
import repository.Usuario_Repository;
import util.Utilidades;


@Service

public class Usuario_Service_Impl implements Usuario_Service {
	
	@Autowired
	Usuario_Repository service;
	

	@Override
	public void darDeAlta(Usuario usuario) {
		
		service.darDeAlta(usuario);
		
		
	}

	@Override
	public void darDeBaja(Usuario usuario) {

		service.darDeBaja(usuario);
		
	}

	@Override
	public List<DtoUsuario> todos() {
		
		List<Usuario>lista=service.todos();
		
		
		return lista.stream().map(d->Utilidades.convertirADtoUsuario(d)).collect(Collectors.toList());
		
	}

	@Override
	public DtoUsuario Logging(String nombre,String password) {
		
		List<Usuario>usuario=service.todos();
		
		usuario.forEach(u->System.out.println(u.getNombre()+"   "+u.getPassword()));
		
		Usuario dtou=  usuario.stream()		        
				.filter(t->t.getNombre().equals(nombre)&&t.getPassword().equals(password))
				.findAny().orElse(null);
		
		System.out.println("este es el dtou "+dtou);
		
		return Utilidades.convertirADtoUsuario(dtou);
		 
		 
	}

	

}
