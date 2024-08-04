package com.icaroweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icaroweb.course.entities.Categoria;
import com.icaroweb.course.services.CategoriaService;

@RestController
@RequestMapping(value = "/Categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscaporId(@PathVariable Long id) {
		Categoria obj = service.buscaporId(id);
		return ResponseEntity.ok().body(obj);
	}

}
