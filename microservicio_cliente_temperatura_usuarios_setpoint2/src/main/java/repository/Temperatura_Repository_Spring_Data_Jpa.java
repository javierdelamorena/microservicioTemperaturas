package repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dto.DtoTemperatura;
import model.Temperatura;

public interface Temperatura_Repository_Spring_Data_Jpa extends JpaRepository<Temperatura,Integer>{
	
	
	@Query("select e from Temperatura  e where e.usuario.idUsuario=?1")
	List<Temperatura> todasLasTemperaturas(int idUsuario);
	
	@Query("select e from Temperatura e where e.usuario.idUsuario=?1 and e.temp1=?2")
	Temperatura UnaTemperatura(int idUsuario,int temp1 );
	
	@Query("SELECT t FROM Temperatura t WHERE t.usuario.idUsuario=?3 and t.fecha between ?1 and ?2")
    List<Temperatura>temperaturaEntreFechas(LocalDateTime fechaIni,LocalDateTime fechaFin,int idUsuario );
	
	@Query("SELECT Max(e.temp1)  FROM Temperatura e WHERE e.usuario.idUsuario=?1 and e.dia=?2")
	
	Double maxTemperaturaDia(int idUsuario,LocalDate fecha);
    @Query("SELECT Min(e.temp1)  FROM Temperatura e WHERE e.usuario.idUsuario=?1 and e.dia=?2")
	
	Double minTemperaturaDia(int idUsuario,LocalDate fecha);
	
     @Query("SELECT Min(e.temp1)  FROM Temperatura e WHERE e.usuario.idUsuario=?1 and e.fecha=?2")
	
	Double minTemperaturaDia(int idUsuario,LocalDateTime fecha);
	
	@Query("SELECT Avg(e.temp1)  FROM Temperatura e WHERE e.usuario.idUsuario=?1")
	Double mediaTemperatura(int idUsuario);

	
	
	

	
}
