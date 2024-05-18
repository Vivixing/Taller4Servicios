package com.co.echeverri.curso.service;

import org.springframework.stereotype.Service;

import com.co.echeverri.common.service.CommonService;
import com.co.echeverri.common.service.CommonServiceImpl;
import com.co.echeverri.common.usuario.models.entity.Curso;
import com.co.echeverri.curso.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso,CursoRepository> implements CommonService<Curso>{

}
