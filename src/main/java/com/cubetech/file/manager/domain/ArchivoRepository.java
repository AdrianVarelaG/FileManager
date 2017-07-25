package com.cubetech.file.manager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ArchivoRepository extends CrudRepository<Archivo, Long> {
	
	public List<Archivo> findByCuentaCorrelacionAndCorrelacion(String cc, String c);
	public Archivo	findOneByCuentaCorrelacionAndCorrelacion(String cc, String c);
	public Long deleteByCuentaCorrelacionAndCorrelacion(String cc, String c);
}
