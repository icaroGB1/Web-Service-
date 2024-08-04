package com.icaroweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaroweb.course.entities.Pedido;
import com.icaroweb.course.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido buscaporId(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}
}
