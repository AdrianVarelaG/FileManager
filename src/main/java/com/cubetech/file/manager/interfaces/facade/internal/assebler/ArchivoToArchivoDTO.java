package com.cubetech.file.manager.interfaces.facade.internal.assebler;

import org.modelmapper.PropertyMap;

import com.cubetech.file.manager.domain.Archivo;
import com.cubetech.file.manager.interfaces.facade.dto.ArchivoDTO;

public class ArchivoToArchivoDTO extends PropertyMap<Archivo, ArchivoDTO> {

	@Override
	protected void configure() {
		map().setContent(source.ContentString());
	}

}
