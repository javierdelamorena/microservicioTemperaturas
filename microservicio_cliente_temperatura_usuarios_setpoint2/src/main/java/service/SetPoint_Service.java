package service;

import java.util.List;

import model.Setpoint;

public interface SetPoint_Service {
	
	
	List<Setpoint> recuperarSetPoint(int idUsuario);
	
	
	void añadirSetPoint(Setpoint set);
	
	void deleteSetPoint(int idUsuario);
	
	void actualizarSetPoint(Setpoint set);

}
