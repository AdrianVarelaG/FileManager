package com.cubetech.file.manager.domain;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface ArchivoRepository extends Repository<Archivo, Long> {
	
	public Archivo save (Archivo arch);
	public List<Archivo> findByCuentaCorrelacionAndCorrelacion(String cc, String c);
	public Archivo	findOneByCuentaCorrelacionAndCorrelacion(String cc, String c);
	public Long deleteByCuentaCorrelacionAndCorrelacion(String cc, String c);
}
