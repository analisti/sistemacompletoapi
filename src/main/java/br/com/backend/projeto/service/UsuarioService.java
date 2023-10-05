package br.com.backend.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.projeto.dto.UsuarioDto;
import br.com.backend.projeto.entity.UsuarioEntity;
import br.com.backend.projeto.repository.UsuarioRepository;

@Service


public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDto> listarTodos(){
		List<UsuarioEntity> usuarios = usuarioRepository.findAll ();
		return usuarios.stream().map(UsuarioDto::new).toList();
	}
	
	public void inserir(UsuarioDto usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
	}
	
	public UsuarioDto alterar(UsuarioDto usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDto(usuarioRepository.save(usuarioEntity));
	}
	
	public void excluir(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	public UsuarioDto buscarPorId(long id) {
		return new UsuarioDto(usuarioRepository.findById(id).get());
	}

}
