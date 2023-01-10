package com.desafioAttornatus.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private Endereço endereço;
	
	private Boolean endereçoPrincipal;
	
	public Pessoa() {
	}

	public Pessoa(String nome, LocalDate dataNascimento, Endereço endereço, Boolean endereçoPrincipal) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereço = endereço;
		this.endereçoPrincipal = endereçoPrincipal;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereço getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}
	
	public Boolean getEndereçoPrincipal() {
		return endereçoPrincipal;
	}

	public void setEndereçoPrincipal(Boolean endereçoPrincipal) {
		this.endereçoPrincipal = endereçoPrincipal;
	}
	
	public void endereçoPrincipal(Boolean endereçoPrincipal) {
		
		if(endereçoPrincipal == true) {
			System.out.println("Esse é o endereço principal!");
		} else {
			System.out.println("Esse é o endereço principal!");
		}
	}	
}
