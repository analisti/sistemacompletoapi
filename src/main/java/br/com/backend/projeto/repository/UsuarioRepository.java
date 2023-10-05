package br.com.backend.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
