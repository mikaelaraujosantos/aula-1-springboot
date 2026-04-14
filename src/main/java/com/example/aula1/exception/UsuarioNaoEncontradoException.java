package com.example.aula1.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}