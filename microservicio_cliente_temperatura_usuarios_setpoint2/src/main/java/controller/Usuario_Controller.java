package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoUsuario;
import model.Usuario;
import service.Usuario_Service;

@RestController
public class Usuario_Controller {

	@Autowired
	Usuario_Service service;

	@GetMapping(value = "Usuariologing/{nombre}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DtoUsuario loging(@PathVariable("nombre") String nombre, @PathVariable("password") String password,
			HttpSession sesion) {
		
		System.out.println("hola");

		DtoUsuario uno = service.Logging(nombre, password);
		
		System.out.println("el loging en el microservicio"+uno.getIdUsuario());
		
		
			sesion.setAttribute("Usuario", uno);
			
		
		return uno;
	}

	@PostMapping(value="UsuarioAlta",consumes= MediaType.APPLICATION_JSON_VALUE)

	public String alta(@RequestBody Usuario usuario) {
		
		Usuario usu=new Usuario(usuario.getIdUsuario(),usuario.getNombre(),usuario.getPassword(),usuario.getEmail());

		service.darDeAlta(usu);

		return "menu";
	}

	@PostMapping(value="UsuarioBaja",consumes= MediaType.APPLICATION_JSON_VALUE)

	public String baja(@RequestBody Usuario usuario) {
		
		Usuario usuarios=new Usuario(usuario.getIdUsuario(),usuario.getNombre(),usuario.getPassword(),usuario.getEmail());

		service.darDeBaja(usuarios);

		return "menu";
	}
	@GetMapping(value="UsuarioTodos",produces=MediaType.APPLICATION_JSON_VALUE)
	
	public List<DtoUsuario> todos(){
		
		return service.todos();
	}

}
