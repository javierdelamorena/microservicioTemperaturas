package repository;



import java.util.List;

import model.Setpoint;

public interface SetPoint_Repository {
	
	
	List<Setpoint> recuperarSetPoint(int idUsuario);
	
	
	void insertarSetPoint(Setpoint set);
	
	void borrarSetPoint(int idUsuario);
	
	void actualizarSetPoint(Setpoint set);

}
