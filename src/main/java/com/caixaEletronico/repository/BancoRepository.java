package com.caixaEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.caixaEletronico.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {

}
