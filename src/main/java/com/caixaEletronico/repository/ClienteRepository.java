package com.caixaEletronico.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.caixaEletronico.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	//public Optional<Cliente> findByUsuario(String usuario);
	//public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
	//public List<Cliente> findAllByAgencia(String agencia);
	//public List<Cliente> findByConta(String conta);
}
