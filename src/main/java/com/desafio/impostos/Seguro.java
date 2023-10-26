package com.desafio.impostos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public record Seguro(
        @Id
        String id,
        String nome,
        String categoria,
        Double precoBase,
        Double precoTarifado
) {
    public Seguro(String nome, String categoria, Double precoBase, Double precoTarifado) {
        this(UUID.randomUUID().toString(), nome, categoria, precoBase, precoTarifado);
    }
}