package com.co.echeverri.common.usuario.models.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name="examen")
@Data
public class Examen {
	
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
	@JsonIgnoreProperties(value= {"examen"},allowSetters=true)
	@OneToMany(mappedBy = "examen" , fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Pregunta>preguntas;
	
    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas.clear();
        if (preguntas != null) {
            preguntas.forEach(this::addPregunta);
        }
    }

    public void addPregunta(Pregunta pregunta) {
        if (pregunta != null) {
            preguntas.add(pregunta);
            pregunta.setExamen(this);
        }
    }

    public void removePregunta(Pregunta pregunta) {
        if (pregunta != null) {
            preguntas.remove(pregunta);
            pregunta.setExamen(null);
        }
    }
	
}
