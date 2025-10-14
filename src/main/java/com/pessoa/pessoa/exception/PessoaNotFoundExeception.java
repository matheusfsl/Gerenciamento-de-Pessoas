package com.pessoa.pessoa.exception;

public class PessoaNotFoundExeception extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PessoaNotFoundExeception(String msg) {
        super(msg);
    }

    public PessoaNotFoundExeception(String msg, Throwable cause) {
        super(msg, cause);
    }
}
