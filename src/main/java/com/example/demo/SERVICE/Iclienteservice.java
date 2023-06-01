package com.example.demo.SERVICE;

import java.util.List;

import com.example.demo.MODEL.ENTITY.cliente;

public interface Iclienteservice {

	public List<cliente> findAll();
	
	public void save(cliente cliente);
	
	public cliente findByid(Long id);
	
	public void delete(long id);
	
}
