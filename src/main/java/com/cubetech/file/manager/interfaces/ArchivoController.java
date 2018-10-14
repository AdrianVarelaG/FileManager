package com.cubetech.file.manager.interfaces;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cubetech.file.manager.application.ArchivoService;
import com.cubetech.file.manager.interfaces.facade.dto.ArchivoDTO;

@RestController
public class ArchivoController {
	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoController.class);
	
	@Autowired
	ArchivoService archivoService;
	
	@RequestMapping("/Archivo/{id}")
	public ResponseEntity<ArchivoDTO> consulta(@RequestHeader(value="cuenta") String cuenta ,@PathVariable String id){
		logger.debug("Cuenta: " + cuenta + "/Id: " + id);
		return new ResponseEntity<ArchivoDTO>(archivoService.consultaArchivo(cuenta, id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/Archivo", method=RequestMethod.POST )
	public List<ArchivoDTO> guarda(@RequestHeader(value="cuenta") String cuenta, @RequestBody List<ArchivoDTO> archivos){
		return archivoService.guardaArchivos(archivos, cuenta);
	}
	@RequestMapping(value="/Archivo/{id}", method=RequestMethod.DELETE )
	public void elimina(@RequestHeader(value="cuenta") String cuenta ,@PathVariable String id){
		logger.debug("cuenta: " + cuenta + "/id: " + id);
		archivoService.elimina(cuenta, id);
	}
}
