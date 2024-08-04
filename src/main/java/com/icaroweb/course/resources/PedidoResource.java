package com.icaroweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icaroweb.course.entities.Pedido;
import com.icaroweb.course.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;

	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscaporId(@PathVariable Long id) {
		Pedido obj = service.buscaporId(id);
		return ResponseEntity.ok().body(obj);
	}

}
