package com.desafioAttornatus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafioAttornatus.entidades.dto.PessoaDTO;
import com.desafioAttornatus.repositorios.PessoaRepositorio;
import com.desafioAttornatus.service.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PessoaDTO> save(@Valid @RequestBody PessoaDTO dto) {
		PessoaDTO cliente = pessoaService.save(dto);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll() {
		List<PessoaDTO> clientes = new ArrayList<>();
		clientes = pessoaService.findAll();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public PessoaDTO findById(@PathVariable Long id) {
		return pessoaService.findById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @Valid @RequestBody PessoaDTO novoCliente){
		if(!pessoaRepositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		novoCliente.setId(id);
		novoCliente = pessoaService.update(novoCliente);
		return ResponseEntity.ok(novoCliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<PessoaDTO>> deleteById(@PathVariable Long id) {
		try {
			pessoaService.delete(id);
			return new ResponseEntity<Optional<PessoaDTO>>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Optional<PessoaDTO>>(HttpStatus.NOT_FOUND);
		}
	}
}
