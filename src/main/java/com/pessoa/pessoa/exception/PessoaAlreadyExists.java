package com.pessoa.pessoa.exception;

public class PessoaAlreadyExists extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PessoaAlreadyExists(String msg) {
        super(msg);
    }

    public PessoaAlreadyExists(String msg, Throwable cause) {
        super(msg, cause);
    }}
