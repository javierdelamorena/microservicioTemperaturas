package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Setpoint;

public interface SetPoint_Repository_Spring_Data_Jpa extends JpaRepository<Setpoint,Integer>{
	
	@Query("select e from Setpoint e where e.idUsuario=?1")
	List<Setpoint> recupearaSetpoint(int idUsuario );

}
