package com.desafio.impostos.core.dto;

import com.desafio.impostos.core.enums.ProdutoEnum;


public record CotacaoRequest(String nome, ProdutoEnum categoria, Double precoBase) {
}
