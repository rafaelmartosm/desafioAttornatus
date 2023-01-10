package com.desafioAttornatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioAttornatus.entidades.Pessoa;
import com.desafioAttornatus.entidades.dto.PessoaDTO;
import com.desafioAttornatus.entidades.exception.RecursoNaoEncontradoException;
import com.desafioAttornatus.mapper.DozerMapper;
import com.desafioAttornatus.repositorios.PessoaRepositorio;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	public PessoaDTO save(PessoaDTO pessoa) {
		var entidade = DozerMapper.parseObject(pessoa, Pessoa.class);
		var dto = DozerMapper.parseObject(pessoaRepositorio.save(entidade), PessoaDTO.class);
		return dto;
	}
	
	public List<PessoaDTO> findAll() {
		var pessoa = DozerMapper.parseListObjects(pessoaRepositorio.findAll(), PessoaDTO.class);
		return pessoa;
	}
	
	public PessoaDTO findById(Long id) {
		var entidade = pessoaRepositorio.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("ID não existe!"));
		var dto = DozerMapper.parseObject(entidade, PessoaDTO.class);
		return dto;
	}
	
	public PessoaDTO update(PessoaDTO pessoa) {
		var entidade = pessoaRepositorio.findById(pessoa.getId()).orElseThrow(() -> 
		new RecursoNaoEncontradoException("ID informado não existe!"));
		
		entidade.setNome(pessoa.getNome());
		entidade.setDataNascimento(pessoa.getDataNascimento());
		entidade.setEndereço(pessoa.getEndereço());
		entidade.setEndereçoPrincipal(pessoa.getEndereçoPrincipal());
		
		var dto = DozerMapper.parseObject(pessoaRepositorio.save(entidade), PessoaDTO.class);
		return dto;
	}
	
	public void delete(Long id) {
		var entidade = pessoaRepositorio.findById(id).orElseThrow(() -> 
		new RecursoNaoEncontradoException("ID informado não existe"));
		pessoaRepositorio.delete(entidade);
	}
}
