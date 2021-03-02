package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Setpoint;
import repository.SetPoint_Repository;

@Service
public class SetPoint_Service_Impl implements SetPoint_Service {

	@Autowired

	SetPoint_Repository service;

	@Override
	public List<Setpoint> recuperarSetPoint(int idUsuario) {

		if (service.recuperarSetPoint(idUsuario) != null) {

			return service.recuperarSetPoint(idUsuario);
		}

		return null;

	}

	@Override
	public void añadirSetPoint(Setpoint set) {

		if (set != null) {

			service.insertarSetPoint(set);

		}

	}

	@Override
	public void deleteSetPoint(int idUsuario) {

		if (idUsuario != 0) {
			service.borrarSetPoint(idUsuario);
		}

	}

	@Override
	public void actualizarSetPoint(Setpoint set) {
		
		if (set != null) {

			service.actualizarSetPoint(set);

		}

		
	}

}
