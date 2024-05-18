package com.co.echeverri.usuarios.service;



import com.co.echeverri.common.service.CommonService;
import com.co.echeverri.common.usuario.models.entity.Alumno;


public interface AlumnoService extends CommonService<Alumno>{
	
	public Alumno save (Alumno alumno);
	
	public void deteById (Long id);

}
