package com.co.echeverri.common.service;

import java.util.Optional;


public interface CommonService <E> {
	
	public Iterable<E> findAll();
	
	public Optional<E> findById(Long id);
	
	public E save (E alumno);
	
	public void deteById (Long id);

}
