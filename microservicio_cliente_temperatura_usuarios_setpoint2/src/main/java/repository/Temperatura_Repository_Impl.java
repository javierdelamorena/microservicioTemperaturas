package repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Temperatura;

@Repository
public class Temperatura_Repository_Impl implements Temperatura_Repository {
	
	@Autowired
	Temperatura_Repository_Spring_Data_Jpa repository;

	@Override
	public List<Temperatura> todasLasTemperaturas(int idUsuario) {
		
		return repository.todasLasTemperaturas(idUsuario);
	}

	@Override
	public Temperatura UnaTemperatura(int temp1, int idUsuario) {
		
		return repository.UnaTemperatura(idUsuario, temp1);
	}

	@Override
	public void InsertarTemperaturas(Temperatura temperatur) {
		
		repository.save(temperatur);
		
	}

	@Override
	public List<Temperatura> temperaturaEntreFechas(LocalDateTime fechaIni, LocalDateTime FechaFin, int idUsuario) {
		
		return repository.temperaturaEntreFechas(fechaIni, FechaFin, idUsuario);
	}

	@Override
	public List<Temperatura> maxTemperatura(int idUsuario) {
		System.out.println("impl");
		return repository.todasLasTemperaturas(idUsuario);
	}

	@Override
	public List<Temperatura> minTemperatura(int idUsuario) {
		System.out.println("impl");
		return  repository.todasLasTemperaturas(idUsuario);
	}

	@Override
	public Double maxTemperaturaDia(LocalDate fecha,int idUsuario ) {
		
		return repository.maxTemperaturaDia(idUsuario,fecha);
	}

	@Override
	public Double  minTemperaturaDia(LocalDate fecha, int idUsuario) {
		
		return repository.minTemperaturaDia(idUsuario, fecha);
	}

	@Override
	public Double mediaTemperatura(int idUsuario) {
		
		return repository.mediaTemperatura(idUsuario);
	}

	

	

	

	

}
