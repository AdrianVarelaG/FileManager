package com.cubetech.file.manager.interfaces.facade.internal.assebler;

import org.modelmapper.PropertyMap;
import com.cubetech.file.manager.domain.Archivo;
import com.cubetech.file.manager.interfaces.facade.dto.ArchivoDTO;

public class ArchivoDtoToArchivo extends PropertyMap<ArchivoDTO, Archivo> {

	@Override
	protected void configure() {
		map().setContent(source.ContentByte());
		skip().setId(null);
		skip().setCuentaCorrelacion(null);
		skip().setCreated(null);
	}

}
