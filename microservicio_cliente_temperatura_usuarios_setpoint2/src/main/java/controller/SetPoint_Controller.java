package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Setpoint;
import service.SetPoint_Service;

@RestController
public class SetPoint_Controller {

	@Autowired
	SetPoint_Service service;

	@PostMapping(value = "SetPointAgregar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Setpoint set) {

		service.añadirSetPoint(set);

	}

	@DeleteMapping(value = "SetPointBorrar/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public void borrar(@PathVariable("idUsuario") int idUsuario) {

		service.deleteSetPoint(idUsuario);

	}

	@GetMapping(value = "SetPointRecuperar/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Setpoint> recuperar(@PathVariable("idUsuario") int idUsuario) {

		return service.recuperarSetPoint(idUsuario);

	}

	@PutMapping(value = "SetPointActualizar", consumes = MediaType.APPLICATION_JSON_VALUE)

	public void actualizar(@RequestBody Setpoint set) {

		service.añadirSetPoint(set);

	}

}
