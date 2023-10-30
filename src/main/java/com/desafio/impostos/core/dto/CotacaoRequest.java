package com.desafio.impostos.core.dto;

import com.desafio.impostos.core.enums.ProdutoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CotacaoRequest(@NotBlank String nome, ProdutoEnum categoria, @NotNull Double precoBase) {
}
