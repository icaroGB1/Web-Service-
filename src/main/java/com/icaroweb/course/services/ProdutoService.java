package com.icaroweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaroweb.course.entities.Produto;
import com.icaroweb.course.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto buscaporId(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}

}
