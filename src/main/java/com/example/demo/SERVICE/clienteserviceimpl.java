package com.example.demo.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.MODEL.DAO.Iclientedao;
import com.example.demo.MODEL.ENTITY.cliente;

@Service
public class clienteserviceimpl implements Iclienteservice{

	@Autowired
	private Iclientedao clientedao;
	
	@Override
	@Transactional(readOnly=true)
	public List<cliente> findAll() {
		return (List<cliente>) clientedao.findAll();
	}

	@Override
	@Transactional
	public void save(cliente cliente) {
		clientedao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly=true)
	public cliente findByid(Long id) {
		return clientedao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(long id) {
		clientedao.deleteById(id);
		
	}

}
