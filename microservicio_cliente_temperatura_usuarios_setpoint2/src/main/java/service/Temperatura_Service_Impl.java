package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DtoTemperatura;
import model.Temperatura;
import repository.Temperatura_Repository;
import util.Utilidades;


@Service

public class Temperatura_Service_Impl implements Temperatura_Service {
	
	@Autowired
	Temperatura_Repository service;

	@Override
	public List<Temperatura> todas(int idUsuario) {
		
		if(service.todasLasTemperaturas(idUsuario)!=null) {
			
			return service.todasLasTemperaturas(idUsuario);
			
		}
		
		return null;
	}

	@Override
	public Temperatura Una(int temp, int idUsuario) {
		
		if(service.UnaTemperatura(temp, idUsuario)!=null) {
			
			return service.UnaTemperatura(temp, idUsuario);
		}
		return null;
	}

	@Override
	public void agregar(Temperatura temperatura) {
		
		service.InsertarTemperaturas(temperatura);
	}

	@Override
	public List<Temperatura> tempEntreFechas(LocalDateTime fechaIni, LocalDateTime FechaFin, int idUsuario) {
		if(fechaIni!=null && FechaFin!=null) {
			
			return service.temperaturaEntreFechas(fechaIni, FechaFin, idUsuario);
		}
		return null;
	}

	@Override
	public List<Temperatura> maxTempService(int idUsuario) {
		
		return service.maxTemperatura(idUsuario);
	}

	@Override
	public List<Temperatura> minTempService(int idUsuario) {
		
		return service.minTemperatura(idUsuario);
	}

	@Override
	public Double maxTempDia(LocalDate fecha, int idUsuario) {
        
		
		return service.maxTemperaturaDia(fecha, idUsuario);
	}

	@Override
	public Double minTempDia(LocalDate fecha, int idUsuario) {
		
		return service.minTemperaturaDia(fecha, idUsuario);
		
		
		
		
		
	}

	@Override
	public Double mediaTemp(int idUsuario) {
		
		return service.mediaTemperatura(idUsuario);
	}
	
	

}
