package com.example.demo.MODEL.ENTITY;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="producto")
public class producto implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Double precio;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createat;
	
	@PrePersist
	public void prePersist() {
		this.createat=new Date();
	}
	
	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Double getPrecio() {
		return precio;
	}




	public void setPrecio(Double precio) {
		this.precio = precio;
	}




	public Date getCreateat() {
		return createat;
	}




	public void setCreateat(Date createat) {
		this.createat = createat;
	}




	private static final long serialVersionUID = 1L;

}
