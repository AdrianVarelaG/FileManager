package com.cubetech.file.manager.application.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cubetech.file.manager.application.ArchivoService;
import com.cubetech.file.manager.domain.Archivo;
import com.cubetech.file.manager.domain.ArchivoRepository;
import com.cubetech.file.manager.interfaces.facade.dto.ArchivoDTO;

@Service
public class ArchivoServiceImpl implements ArchivoService {

	@Autowired
	private ArchivoRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ArchivoDTO consultaArchivo(String cuenta, String correlation) {
		ArchivoDTO a = null;
		List<Archivo> la;
		la = repository.findByCuentaCorrelacionAndCorrelacion(cuenta, correlation);
		for(Archivo arch: la){
			a = modelMapper.map( arch , ArchivoDTO.class);
		}
		return a;
	}

	@Override
	@Transactional
	public boolean elimina(String cuenta, String correlation) {
		Long l = repository.deleteByCuentaCorrelacionAndCorrelacion(cuenta, correlation);
		return l.longValue() > 0;
	}
	@Transactional
	@Override
	public List<ArchivoDTO> guardaArchivos(List<ArchivoDTO> la, String cuenta) {
		// TODO Auto-generated method stub
		List<ArchivoDTO> ret = new ArrayList<ArchivoDTO>();
		Archivo arch;
		Archivo tmp;
		for(ArchivoDTO a: la){
			arch = modelMapper.map(a, Archivo.class);
			tmp = repository.findOneByCuentaCorrelacionAndCorrelacion(cuenta, arch.getCorrelacion());
			if(tmp != null){
				arch.setId(tmp.getId());
			}
			arch.setCuentaCorrelacion(cuenta);
			repository.save(arch);
			ret.add(new ArchivoDTO(arch.getCorrelacion(), arch.getId()));
		}
		
		return ret;
	}
	

}
