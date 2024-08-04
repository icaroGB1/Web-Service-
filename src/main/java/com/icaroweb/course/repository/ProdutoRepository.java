package com.icaroweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaroweb.course.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
