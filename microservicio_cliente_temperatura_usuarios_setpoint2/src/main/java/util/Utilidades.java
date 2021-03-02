package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import dto.DtoTemperatura;
import dto.DtoUsuario;
import model.Temperatura;
import model.Usuario;

public class Utilidades {

	public static LocalDate convertirDateALocalDate(Date fecha) { // convertir Date a LocalDate

		LocalDate ld = Instant.ofEpochMilli(fecha.getTime()) // Instant
				.atZone(ZoneId.systemDefault()) // ZoneDateTime
				.toLocalDate();
		System.out.println(ld);

		return ld;
	}

	public static Date convertirLocalDateADate(LocalDate fecha) {// convertir LocalDate a Date

		Date fe = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()) // ZoneDateTime
				.toInstant()); // Instrant
		System.out.println(fe);
		return fe;
	}

	public static DtoTemperatura convertirADtoTempraratura(Temperatura temperatura) {

		return new DtoTemperatura(temperatura.getTemp1(),
				temperatura.getHumedad(), 
				temperatura.getFecha().toString(),temperatura.getUsuario().getIdUsuario());
	}
	public static Temperatura candidatoEntityBuilder(DtoTemperatura dtoTemperatura) {
		
		Temperatura entity=new Temperatura();
		entity.getIdtemp();
		entity.setHumedad(dtoTemperatura.getHumedad());;
		entity.setFecha(LocalDateTime.parse(dtoTemperatura.getFecha()));
		entity.setDia(dtoTemperatura.getDia());
		entity.setUsuario(new Usuario());
		
		return entity;
	}

	public static LocalDate cambioFormato(String fecha) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(fecha, inputFormatter);
		String formattedDate = outputFormatter.format(date);

		return date.plusDays(1);
	}
	public static String cambioFormatoString(String fecha) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(fecha, inputFormatter);
		String formattedDate = outputFormatter.format(date);

		return formattedDate;
	}
	public static String cambioFormato4(String fecha) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDateTime date = LocalDateTime.parse(fecha, inputFormatter);
		String formattedDate = outputFormatter.format(date.plusHours(1));
		
		return formattedDate;
	}
	public static DtoUsuario convertirADtoUsuario(Usuario usuario) {
		
		
		return new DtoUsuario(usuario.getIdUsuario(),usuario.getEmail(),usuario.getNombre(),usuario.getPassword());
	}

}
