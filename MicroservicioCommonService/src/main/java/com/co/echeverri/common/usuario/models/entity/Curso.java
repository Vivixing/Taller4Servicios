package com.co.echeverri.common.usuario.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*; 

@Entity
@Table(name="cursos")
@Data
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAT;
	@PrePersist
	private void prePersist() {
		this.createAT = new Date();
	}
	@OneToMany(fetch = FetchType.LAZY)
	private List<Alumno> listAlumno;
	
	public Curso() {
		listAlumno = new ArrayList<>();
	}
	public void addAlumnos (Alumno alumno) {
		listAlumno.add(alumno);
	}
	public void removeAlumnos (Alumno alumno) {
		listAlumno.remove(alumno);
	}
	
}
