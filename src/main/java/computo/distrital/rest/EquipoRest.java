package computo.distrital.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import computo.distrital.model.Equipo;
import computo.distrital.service.EquipoService;

@RestController
@RequestMapping("/equipo/")
public class EquipoRest {
	
	@Autowired
	private EquipoService equipoService;
	
	@GetMapping
	private ResponseEntity<List<Equipo>> getAllEquipos(){
		return ResponseEntity.ok(equipoService.findAll());
		
	}
	
	@PostMapping
	private ResponseEntity<Equipo> saveEquipo(@RequestBody Equipo equipo){
		
		try {
			Equipo equipoGuardado = equipoService.save(equipo);
			return ResponseEntity.created(new URI("/equipo/"+equipoGuardado.getIdEquipo())).body(equipoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping
	private ResponseEntity<Boolean> editarSaldo(@RequestBody Equipo equipo){
		
		equipoService.editarEquipo(equipo.getGoles(), equipo.getPuntos(), equipo.getIdEquipo());
		//return ResponseEntity.created(new URI("/tarjeta/"+tarjetaEditada.getId())).body(tarjetaEditada);
		return ResponseEntity.ok(equipoService.findById(equipo.getIdEquipo())!=null);
		
	}
}
