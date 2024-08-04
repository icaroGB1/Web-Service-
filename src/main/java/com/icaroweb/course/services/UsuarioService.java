package com.icaroweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.icaroweb.course.entities.Usuario;
import com.icaroweb.course.repository.UsuarioRepository;
import com.icaroweb.course.services.Exception.DatabaseException;
import com.icaroweb.course.services.Exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario buscaporId(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario insercao(Usuario obj) {
		return repository.save(obj);
	}

	public void delecao(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Usuario atualizar(Long id, Usuario obj) {
		try {
		Usuario entidade = repository.getReferenceById(id);// (prepara o objeto) monitorar antes de fazer operação no
															// banco
		atualizarData(entidade, obj);
		return repository.save(entidade);
		}catch(EntityNotFoundException e ) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void atualizarData(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}

}
