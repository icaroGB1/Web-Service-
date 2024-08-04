package com.icaroweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaroweb.course.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
