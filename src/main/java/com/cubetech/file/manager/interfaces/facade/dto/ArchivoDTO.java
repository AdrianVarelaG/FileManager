package com.cubetech.file.manager.interfaces.facade.dto;

import org.apache.tomcat.util.codec.binary.Base64;

import lombok.Data;

@Data
public class ArchivoDTO {
	private String correlacion;
	private String nombre;
	private String content;
	private String tipo;
	private String id;
	
	public ArchivoDTO(String correlation, String id){
		this.correlacion = correlation;
		this.id					 = id;
	}
	public ArchivoDTO(){
		
	}
	
	public byte[] ContentByte(){
		byte[] b = Base64.decodeBase64(content);
		return b;
	}
	

}
