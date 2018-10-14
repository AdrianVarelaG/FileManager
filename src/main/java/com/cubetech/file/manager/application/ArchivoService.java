package com.cubetech.file.manager.application;

import java.util.List;

import com.cubetech.file.manager.interfaces.facade.dto.ArchivoDTO;

public interface ArchivoService {
	
	public ArchivoDTO consultaArchivo(String cuenta, String correlation);
	public boolean elimina(String cuenta, String correlation);
	public List<ArchivoDTO> guardaArchivos(List<ArchivoDTO> la, String cuenta);
}
