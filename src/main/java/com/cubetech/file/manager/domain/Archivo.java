package com.cubetech.file.manager.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cubetech.file.manager.domain.shared.Entidad;

import lombok.Data;

@Data
@Table(indexes = @Index(columnList = "cuentaCorrelacion, correlacion", unique= true))
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Archivo implements Entidad<Archivo> {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(nullable= false, name="cuentaCorrelacion")
	private String cuentaCorrelacion;
	
	@Column(name="correlacion", nullable = false)
	private String correlacion;
	
	private String nombre;
	
	@Lob
	@Column(length = 20971520, nullable = false)
	private byte[] content;
	
	private String tipo;
	
	@CreatedDate
	@Column( updatable = false, nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	public String ContentString(){
		return Base64.encodeBase64String(content);
	}
	
	@Override
	public boolean sameIdentityAs(Archivo other) {
		return this.cuentaCorrelacion.equals(other.cuentaCorrelacion) && 
					 this.correlacion.equals(other.correlacion) && 
					 Arrays.equals(this.content, other.content);
	}

}
