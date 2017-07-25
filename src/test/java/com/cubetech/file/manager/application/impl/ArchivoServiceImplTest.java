package com.cubetech.file.manager.application.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.cubetech.file.manager.domain.Archivo;
import com.cubetech.file.manager.interfaces.facade.dto.ArchivoDTO;
import com.cubetech.file.manager.interfaces.facade.internal.assebler.ArchivoDtoToArchivo;

public class ArchivoServiceImplTest {
	
	

	@Test
	public void testModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.createTypeMap(ArchivoDTO.class, Archivo.class);
		modelMapper.addMappings(new ArchivoDtoToArchivo());
		modelMapper.validate();
	}

}
