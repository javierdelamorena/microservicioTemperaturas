package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoTemperatura;
import model.Temperatura;
import model.Usuario;
import service.Temperatura_Service;
import service.Usuario_Service;
import util.Utilidades;

@RestController
public class Temperatura_Controller {

	@Autowired
	Temperatura_Service service;

	@Autowired

	Usuario_Service service1;

	@GetMapping(value = "Temp/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoTemperatura> temperaturas(@PathVariable("idUsuario") int idUsuario) {

		List<Temperatura> listas = service.todas(idUsuario);

		List<DtoTemperatura> lista = new ArrayList<>();

		for (Temperatura e : listas) {

			lista.add(new DtoTemperatura(e.getTemp1(), e.getHumedad(), e.getFecha().toString(),
					e.getUsuario().getIdUsuario()));

		}

		return lista;
	}

	@GetMapping(value = "Temperatura/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> temperatura(@PathVariable("idUsuario") int idUsuario) {

		List<Temperatura> listas = service.todas(idUsuario);

		List<DtoTemperatura> listaString = new ArrayList<>();

		for (Temperatura e : listas) {

			listaString.add(new DtoTemperatura(e.getTemp1(), e.getHumedad(), e.getFecha().toString(),
					e.getUsuario().getIdUsuario()));

		}

		return listaString;
	}

	@PostMapping(value = "TemperaturasAgregar/{temp1}/{humedad}/{idUsuario}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String agregar(@PathVariable("temp1") String temp, @PathVariable("humedad") String humedad,
			@PathVariable("idUsuario") int idUsuario, HttpSession sesion) {
		LocalDateTime fecha = LocalDateTime.now().withNano(0);

		LocalDate dia = LocalDate.now();

		Usuario usuario = (Usuario) sesion.getAttribute("usuario");

		Temperatura temperatura = new Temperatura(Integer.parseInt(humedad), Integer.parseInt(temp), dia, fecha,
				new Usuario(idUsuario, null, null, null));

		sesion.setAttribute("temp", Utilidades.convertirADtoTempraratura(temperatura));
		service.agregar(temperatura);

		return "respuestaMicro.html";
	}

	@GetMapping(value = "TemperaturaEntreFechas/{fecha1}/{fecha2}/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> tempEntreFechas(@PathVariable("fecha1") String fecha1,
			@PathVariable("fecha2") String fecha2, @PathVariable("idUsuario") int idUsuario, HttpSession sesion) {
		System.out.println(fecha1 + "    " + fecha2);

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		LocalDateTime fech1 = LocalDateTime.parse(fecha1, format);
		LocalDateTime fech2 = LocalDateTime.parse(fecha2, format);

		System.out.println("esta es fech1   " + fech1 + "  esta es fech2  " + fech2);

		List<Temperatura> listas = service.tempEntreFechas(fech1, fech2, idUsuario);

		List<DtoTemperatura> listaString = new ArrayList<>();

		for (Temperatura e : listas) {

			listaString.add(new DtoTemperatura(e.getTemp1(), e.getHumedad(), e.getFecha().toString(), idUsuario));

		}
		listaString.forEach(l -> System.out.println(l.getFecha()));

		return listaString;
	}

	@GetMapping(value = "TemperaturaMaxima/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> maxima(@PathVariable("idUsuario") int idUsuario) {

		List<Temperatura> listas = service.minTempService(idUsuario);

		// listas.forEach(l->System.out.println(l.getHumedad()));

		List<DtoTemperatura> tempMax = new ArrayList<>();

		for (Temperatura e : listas) {

			tempMax.add(new DtoTemperatura(e.getTemp1(), e.getHumedad(), e.getFecha().toString(), idUsuario));

		}

		return tempMax;

	}

	@GetMapping(value = "TemperaturaMinima/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> minima(@PathVariable("idUsuario") int idUsuario) {

		List<Temperatura> listas = service.minTempService(idUsuario);

		List<DtoTemperatura> tempMin = new ArrayList<>();

		for (Temperatura e : listas) {

			tempMin.add(new DtoTemperatura(e.getTemp1(), e.getHumedad(), e.getFecha().toString(), idUsuario));

		}

		System.out.println("esto es temperatura maxima" + idUsuario);

		return tempMin;

	}

	@GetMapping(value = "TemperaturaMaximaDia/{fecha}/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody Double maximaTemperaturaDia(@PathVariable("fecha") String fecha,
			@PathVariable("idUsuario") int idUsuario) {

		System.out.println("esta es lo que llega al micro" + fecha);

		LocalDate nfecha = LocalDate.parse(Utilidades.cambioFormato4(fecha));

		Double max = service.maxTempDia(nfecha, idUsuario);

		return max;

	}

	@GetMapping(value = "TemperaturaMinimaDia/{fecha}/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody Double minimaTemperatura(@PathVariable("fecha") String fecha,
			@PathVariable("idUsuario") int idUsuario) {

		System.out.println("esta es la fecha" + fecha);

		System.out.println("esta es lo que llega al micro" + fecha);

		LocalDate nfecha = LocalDate.parse(Utilidades.cambioFormato4(fecha));

		Double min = service.minTempDia(nfecha, idUsuario);
		return min;

	}

	@GetMapping(value = "TemperaturaMedia/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody Double mediaTemperatura(@PathVariable("idUsuario") int idUsuario) {

		Double temp = service.mediaTemp(idUsuario);
		return temp;

	}

}
