package repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Setpoint;
@Repository
public class SetPoint_Repository_Impl implements SetPoint_Repository {

	@Autowired

	SetPoint_Repository_Spring_Data_Jpa repository;

	@Override
	public List<Setpoint> recuperarSetPoint(int idUsuario) {

		return repository.recupearaSetpoint(idUsuario);
	}

	@Override
	public void insertarSetPoint(Setpoint set) {

		repository.save(set);

	}

	@Override
	public void borrarSetPoint(int idUsuario) {

		repository.deleteById(idUsuario);
	}

	@Override
	public void actualizarSetPoint(Setpoint set) {
		
		repository.save(set);
		
	}

}
