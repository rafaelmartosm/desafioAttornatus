package com.desafioAttornatus.entidades.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.desafioAttornatus.entidades.Endereço;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PessoaDTO {
	
		@JsonProperty("id")
		private Long key;
		
		private String nome;
		
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		private LocalDate dataNascimento;
		
		private Endereço endereço;
		
		private Boolean endereçoPrincipal;

		public PessoaDTO() {
		}
		
		public PessoaDTO(String nome, LocalDate dataNascimento, Endereço endereço, Boolean endereçoPrincipal) {
			super();
			this.nome = nome;
			this.dataNascimento = dataNascimento;
			this.endereço = endereço;
			this.endereçoPrincipal = endereçoPrincipal;
		}
		
		public Long getId() {
			return key;
		}

		public void setId(Long id) {
			this.key = id;
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

}
