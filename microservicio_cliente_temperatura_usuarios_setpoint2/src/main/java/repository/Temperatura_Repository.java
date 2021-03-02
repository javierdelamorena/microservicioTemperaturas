package repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import model.Temperatura;

public interface Temperatura_Repository {
	
	
	List<Temperatura> todasLasTemperaturas(int idUsuario );
	Temperatura UnaTemperatura(int temp,int idUsuario );
	void InsertarTemperaturas(Temperatura temperatur );
	List<Temperatura>temperaturaEntreFechas(LocalDateTime fechaIni,LocalDateTime FechaFin,int idUsuario );
	List<Temperatura> maxTemperatura(int idUsuario);
	List<Temperatura> minTemperatura(int idUsuario);
	Double maxTemperaturaDia(LocalDate fecha,int idUsuario);
	Double minTemperaturaDia(LocalDate fecha,int idUsuario);
	Double mediaTemperatura(int idUsuario);
	
	

}
