package com.desafio.impostos.core.dto;

public record CotacaoResponse(String id, String nome, String categoria, Double precoBase, Double precoTarifado) {
}