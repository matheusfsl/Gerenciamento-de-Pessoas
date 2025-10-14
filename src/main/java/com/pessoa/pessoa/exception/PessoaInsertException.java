package com.pessoa.pessoa.exception;

public class PessoaInsertException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PessoaInsertException(String msg) {
        super(msg);
    }

    public PessoaInsertException(String msg, Throwable cause) {
        super(msg, cause);
    }}
