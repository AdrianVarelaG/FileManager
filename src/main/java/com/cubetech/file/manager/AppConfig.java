package com.cubetech.file.manager;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.cubetech.file.manager.interfaces.facade.internal.assebler.ArchivoDtoToArchivo;
import com.cubetech.file.manager.interfaces.facade.internal.assebler.ArchivoToArchivoDTO;

@Configuration
@EnableJpaAuditing
public class AppConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new ArchivoDtoToArchivo());
		modelMapper.addMappings(new ArchivoToArchivoDTO());
	  return modelMapper;
	}

}
