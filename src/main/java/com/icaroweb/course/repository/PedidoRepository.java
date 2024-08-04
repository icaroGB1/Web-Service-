package com.icaroweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaroweb.course.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
