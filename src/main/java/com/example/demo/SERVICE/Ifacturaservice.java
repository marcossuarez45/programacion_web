package com.example.demo.SERVICE;

import java.util.List;

import com.example.demo.MODEL.ENTITY.factura;

public interface Ifacturaservice {

public List<factura> findAll();
	
	public void save(factura factura);
	
	public factura editar(Long id);
	
	public void delete(long id);
	
}
