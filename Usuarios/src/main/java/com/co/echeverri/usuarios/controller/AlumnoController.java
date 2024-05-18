package com.co.echeverri.usuarios.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.echeverri.common.controller.CommonController;
import com.co.echeverri.common.usuario.models.entity.Alumno;
import com.co.echeverri.usuarios.service.AlumnoService;



@RestController
public class AlumnoController extends CommonController<Alumno,AlumnoService>{
	
	@Autowired
	AlumnoService service;
	
	@Value("${config.balanceador.test}")
	private String balanceadorTest;
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Alumno> ob = service.findById(id);
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Alumno alumnoBd = ob.get();
		alumnoBd.setNombre(alumno.getNombre());
		alumnoBd.setApellido(alumno.getApellido());
		alumnoBd.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoBd));
	}

}
