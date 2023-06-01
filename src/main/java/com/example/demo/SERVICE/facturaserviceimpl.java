package com.example.demo.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.MODEL.DAO.Ifacturadao;
import com.example.demo.MODEL.ENTITY.factura;

public class facturaserviceimpl implements Ifacturaservice {

	@Autowired
	private Ifacturadao facturadao;
	
	@Override
	@Transactional(readOnly=true)
	public List<factura> findAll() {
		return (List<factura>) facturadao.findAll();
	}

	@Override
	@Transactional
	public void save(factura factura) {
		facturadao.save(factura);
		
	}

	@Override
	@Transactional(readOnly=true)
	public factura editar(Long id) {
		return facturadao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(long id) {
		facturadao.deleteById(id);
		
	}

	
}
