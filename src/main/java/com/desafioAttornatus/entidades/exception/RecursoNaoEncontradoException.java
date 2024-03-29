package com.desafioAttornatus.entidades.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

		public RecursoNaoEncontradoException(String ex) {
			super(ex);
		}
}
