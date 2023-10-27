package com.desafio.impostos.core.strategy;

import com.desafio.impostos.core.enums.ProdutoEnum;

public interface TarifaProduto {

    ProdutoEnum identify();

    Double cotar(Double precoBase);
}