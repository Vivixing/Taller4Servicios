package com.co.echeverri.usuarios.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.echeverri.common.usuario.models.entity.Alumno;
import com.co.echeverri.usuarios.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	AlumnoRepository dao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		return dao.save(alumno);
	}

	@Override
	@Transactional
	public void deteById(Long id) {
		dao.deleteById(id);
		
	}

}
