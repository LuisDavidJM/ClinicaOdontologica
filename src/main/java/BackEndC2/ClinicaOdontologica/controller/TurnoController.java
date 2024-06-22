package BackEndC2.ClinicaOdontologica.controller;

import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.entity.Paciente;
import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.exception.ResourceNotFoundException;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;
import BackEndC2.ClinicaOdontologica.service.PacienteService;
import BackEndC2.ClinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


  @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno){

      Optional<Paciente> pacienteBuscado= pacienteService.buscarPorID(turno.getPaciente().getId());
      Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorID(turno.getOdontologo().getId());

      if(pacienteBuscado.isPresent()&&odontologoBuscado.isPresent()){
          turno.setPaciente(pacienteBuscado.get());
          turno.setOdontologo(odontologoBuscado.get());
          return ResponseEntity.ok(turnoService.registrarTurno(turno));
      }else{
          //bad request or not found
          return ResponseEntity.badRequest().build();
      }
          }
    @GetMapping
    public ResponseEntity<List<Turno>> listarTodosLosTurnos(){
        return ResponseEntity.ok(turnoService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Long id){
        Optional<Turno> turnoBuscado= turnoService.buscarTurnoId(id);
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    public ResponseEntity<String> actualizarTurno(@RequestBody Turno turno){
        //necesitamos primeramente validar si existe o  no
        Optional<Turno> turnoBuscado= turnoService.buscarTurnoId(turno.getId());
        if(turnoBuscado.isPresent()){
            turnoService.actualizarTurno(turno);
            return ResponseEntity.ok("turno actualizado");
        }else{
            return  ResponseEntity.badRequest().body("no se encontro turno");
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Turno> turnoBuscado= turnoService.buscarTurnoId(id);
        if(turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("turno eliminado con exito");
        }else{
            //aca lanzamos la exception
            throw new ResourceNotFoundException("No existe ese id : "+id);
        }
    }
}
