package com.example.demo.MODEL.ENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="factura")
public class factura implements Serializable {

	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String observacion;
		private String descripcion;
		
		@Column(name="create_at")
		@Temporal(TemporalType.DATE)
		private Date createat;
		
		@JsonIgnoreProperties(value={"factura","hibernaLazyInitializer"}, allowSetters=true)
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="cliente_id")
		public cliente cliente;

		@JsonIgnoreProperties({"hibernaLazyInitializer", "handler"})
		@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
		@JoinColumn(name="factura_id")
		public List<Itemfactura> items;
		
		@PrePersist
		public void prePersist() {
			this.createat=new Date();
		}
		
		public factura() {
			this.items=new ArrayList<>();
		}
		
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getObservacion() {
			return observacion;
		}

		public void setObservacion(String observacion) {
			this.observacion = observacion;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Date getCreateat() {
			return createat;
		}

		public void setCreateat(Date createat) {
			this.createat = createat;
		}

		public cliente getCliente() {
			return cliente;
		}

		public void setCliente(cliente cliente) {
			this.cliente = cliente;
		}

		public List<Itemfactura> getItems() {
			return items;
		}

		public void setItems(List<Itemfactura> items) {
			this.items = items;
		}



		private static final long serialVersionUID = 1L;
		
}
