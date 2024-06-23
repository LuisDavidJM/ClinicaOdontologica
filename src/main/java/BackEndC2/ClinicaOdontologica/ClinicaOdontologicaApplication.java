package BackEndC2.ClinicaOdontologica;


import BackEndC2.ClinicaOdontologica.entity.Domicilio;
import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.entity.Paciente;
import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;
import BackEndC2.ClinicaOdontologica.service.PacienteService;
import BackEndC2.ClinicaOdontologica.service.TurnoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ClinicaOdontologicaApplication.class, args);

		PacienteService pacienteService = context.getBean(PacienteService.class);
		OdontologoService odontologoService = context.getBean(OdontologoService.class);
		TurnoService turnoService = context.getBean(TurnoService.class);

		// 10 pacientes
		Paciente paciente1 = pacienteService.guardarPaciente(new Paciente("Juan", "Perez", "123456", LocalDate.of(2024, 6, 19), new Domicilio("Calle 1", 101, "Ciudad1", "México"), "juan.perez@example.com"));
		Paciente paciente2 = pacienteService.guardarPaciente(new Paciente("Maria", "Lopez", "234567", LocalDate.of(2024, 6, 20), new Domicilio("Calle 2", 102, "Ciudad2", "México"), "maria.lopez@example.com"));
		Paciente paciente3 = pacienteService.guardarPaciente(new Paciente("Carlos", "Gomez", "345678", LocalDate.of(2024, 6, 21), new Domicilio("Calle 3", 103, "Ciudad3", "México"), "carlos.gomez@example.com"));
		Paciente paciente4 = pacienteService.guardarPaciente(new Paciente("Ana", "Martinez", "456789", LocalDate.of(2024, 6, 22), new Domicilio("Calle 4", 104, "Ciudad4", "México"), "ana.martinez@example.com"));
		Paciente paciente5 = pacienteService.guardarPaciente(new Paciente("Luis", "Rodriguez", "567890", LocalDate.of(2024, 6, 23), new Domicilio("Calle 5", 105, "Ciudad5", "México"), "luis.rodriguez@example.com"));
		Paciente paciente6 = pacienteService.guardarPaciente(new Paciente("Laura", "Fernandez", "678901", LocalDate.of(2024, 6, 24), new Domicilio("Calle 6", 106, "Ciudad6", "México"), "laura.fernandez@example.com"));
		Paciente paciente7 = pacienteService.guardarPaciente(new Paciente("Miguel", "Garcia", "789012", LocalDate.of(2024, 6, 25), new Domicilio("Calle 7", 107, "Ciudad7", "México"), "miguel.garcia@example.com"));
		Paciente paciente8 = pacienteService.guardarPaciente(new Paciente("Sara", "Sanchez", "890123", LocalDate.of(2024, 6, 26), new Domicilio("Calle 8", 108, "Ciudad8", "México"), "sara.sanchez@example.com"));
		Paciente paciente9 = pacienteService.guardarPaciente(new Paciente("David", "Torres", "901234", LocalDate.of(2024, 6, 27), new Domicilio("Calle 9", 109, "Ciudad9", "México"), "david.torres@example.com"));
		Paciente paciente10 = pacienteService.guardarPaciente(new Paciente("Laura", "Hernandez", "012345", LocalDate.of(2024, 6, 28), new Domicilio("Calle 10", 110, "Ciudad10", "México"), "laura.hernandez@example.com"));

		// 10 odontólogos
		Odontologo odontologo1 = odontologoService.registrarOdontologo(new Odontologo("MP1", "Pedro", "Alvarez"));
		Odontologo odontologo2 = odontologoService.registrarOdontologo(new Odontologo("MP2", "Sofia", "Gutierrez"));
		Odontologo odontologo3 = odontologoService.registrarOdontologo(new Odontologo("MP3", "Jose", "Diaz"));
		Odontologo odontologo4 = odontologoService.registrarOdontologo(new Odontologo("MP4", "Carmen", "Silva"));
		Odontologo odontologo5 = odontologoService.registrarOdontologo(new Odontologo("MP5", "Ricardo", "Morales"));
		Odontologo odontologo6 = odontologoService.registrarOdontologo(new Odontologo("MP6", "Patricia", "Mendoza"));
		Odontologo odontologo7 = odontologoService.registrarOdontologo(new Odontologo("MP7", "Javier", "Castro"));
		Odontologo odontologo8 = odontologoService.registrarOdontologo(new Odontologo("MP8", "Andrea", "Romero"));
		Odontologo odontologo9 = odontologoService.registrarOdontologo(new Odontologo("MP9", "Martin", "Vargas"));
		Odontologo odontologo10 = odontologoService.registrarOdontologo(new Odontologo("MP10", "Paula", "Rojas"));

		// 10 turnos
		turnoService.registrarTurno(new Turno(paciente1, odontologo1, LocalDate.of(2024, 7, 1)));
		turnoService.registrarTurno(new Turno(paciente2, odontologo2, LocalDate.of(2024, 7, 2)));
		turnoService.registrarTurno(new Turno(paciente3, odontologo3, LocalDate.of(2024, 7, 3)));
		turnoService.registrarTurno(new Turno(paciente4, odontologo4, LocalDate.of(2024, 7, 4)));
		turnoService.registrarTurno(new Turno(paciente5, odontologo5, LocalDate.of(2024, 7, 5)));
		turnoService.registrarTurno(new Turno(paciente6, odontologo6, LocalDate.of(2024, 7, 6)));
		turnoService.registrarTurno(new Turno(paciente7, odontologo7, LocalDate.of(2024, 7, 7)));
		turnoService.registrarTurno(new Turno(paciente8, odontologo8, LocalDate.of(2024, 7, 8)));
		turnoService.registrarTurno(new Turno(paciente9, odontologo9, LocalDate.of(2024, 7, 9)));
		turnoService.registrarTurno(new Turno(paciente10, odontologo10, LocalDate.of(2024, 7, 10)));
	}

}
