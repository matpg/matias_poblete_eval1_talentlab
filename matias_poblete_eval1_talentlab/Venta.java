package com.everis.data.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //representa entidad-modelo
@Table(name = "ventas")

public class Venta {
	
	//id
	@Id //llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrementar
	private Long id;
	private String codigo;
	private Integer cantidad;
	private String distribuidor;
	
	public Venta() {
		super();
	}

	public Venta(Long id, String codigo, Integer cantidad, String distribuidor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.distribuidor = distribuidor;
	}
	
	//genera nuevas tablas, de fechas de creacion y actualizacion
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	

}
