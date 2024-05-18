package com.co.echeverri.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.echeverri.common.controller.CommonController;
import com.co.echeverri.common.usuario.models.entity.Alumno;
import com.co.echeverri.common.usuario.models.entity.Curso;
import com.co.echeverri.curso.service.CursoService;


@RestController
public class CursoController extends CommonController<Curso, CursoService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody Curso curso, @PathVariable Long id){
		Optional<Curso> ob = service.findById(id);
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoBd = ob.get();
		cursoBd.setId(curso.getId());
		cursoBd.setNombre(curso.getNombre());
		cursoBd.setCreateAT(curso.getCreateAT());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
	}
	@PutMapping("/{id}/asignar-alumno")
	public ResponseEntity<?> asignarAlumno (@RequestBody List<Alumno> alumno, @PathVariable Long id){
		Optional<Curso> ob = service.findById(id);
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoBd = ob.get();
		alumno.forEach(a -> {cursoBd.addAlumnos(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
	}
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno (@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Curso> ob = service.findById(id);
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoBd = ob.get();
		cursoBd.removeAlumnos(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
	}


}
