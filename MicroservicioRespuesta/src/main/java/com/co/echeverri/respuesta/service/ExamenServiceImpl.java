package com.co.echeverri.respuesta.service;

import org.springframework.stereotype.Service;

import com.co.echeverri.common.service.CommonService;
import com.co.echeverri.common.service.CommonServiceImpl;
import com.co.echeverri.respuesta.repository.ExamenRepository;
import com.co.echeverri.common.usuario.models.entity.Examen;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen,ExamenRepository> implements CommonService<Examen>{

}
