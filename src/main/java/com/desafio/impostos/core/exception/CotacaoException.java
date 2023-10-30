package com.desafio.impostos.core.exception;

import lombok.Getter;

@Getter
public class CotacaoException extends RuntimeException {

    public CotacaoException(String msg) {
        super(msg);
    }
}