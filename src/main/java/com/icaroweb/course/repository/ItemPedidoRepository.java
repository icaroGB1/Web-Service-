package com.icaroweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaroweb.course.entities.ItemPedido;
import com.icaroweb.course.entities.pk.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

}
