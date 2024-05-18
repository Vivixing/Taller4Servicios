package com.co.echeverri.common.usuario.models.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	private String apellido;
	private String email;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	private void prePersiste() {
		this.createAt = new Date();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Alumno)) {
			return false;
		}
		Alumno a = (Alumno) obj;
		return this.Id != null && this.Id.equals(a.getId());
	}

}
