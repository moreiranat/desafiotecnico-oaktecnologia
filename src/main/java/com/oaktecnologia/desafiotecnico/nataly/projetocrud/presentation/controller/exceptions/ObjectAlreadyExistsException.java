package com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.controller.exceptions;

public class ObjectAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ObjectAlreadyExistsException(String message) {
        super(message);
    }

}
