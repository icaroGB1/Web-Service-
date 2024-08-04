package com.icaroweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaroweb.course.entities.Categoria;
import com.icaroweb.course.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria buscaporId(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.get();
	}

}
