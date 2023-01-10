package com.desafioAttornatus.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioAttornatus.entidades.Pessoa;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
}
