package com.icaroweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaroweb.course.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
