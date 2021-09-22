package com.caixaEletronico.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.caixaEletronico.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuario(String usuario);
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);
	public List<Usuario> findAllByAgencia(String agencia);
	public List<Usuario> findByConta(String conta);
}
