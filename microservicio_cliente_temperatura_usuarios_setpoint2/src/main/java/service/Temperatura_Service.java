package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dto.DtoTemperatura;
import model.Temperatura;

public interface Temperatura_Service {
	
	List<Temperatura> todas(int idUsuario );
	Temperatura Una(int temp,int idUsuario );
	void agregar(Temperatura temperatura );
	List<Temperatura>tempEntreFechas(LocalDateTime fechaIni,LocalDateTime FechaFin,int idUsuario );
	List<Temperatura> maxTempService(int idUsuario);
	List<Temperatura> minTempService(int idUsuario);
	Double maxTempDia(LocalDate fecha,int idUsuario);
	Double minTempDia(LocalDate fecha,int idUsuario);
	Double mediaTemp(int idUsuario);

}
