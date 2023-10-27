package com.desafio.impostos.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seguro {

    @Id
    private String id;
    private String nome;
    private String categoria;
    private Double precoBase;
    private Double precoTarifado;

    public Seguro(String nome, String categoria, Double precoBase, Double precoTarifado) {
        this(UUID.randomUUID().toString(), nome, categoria, precoBase, precoTarifado);
    }

    public void setPrecoTarifado(Double precoTarifado) {
        this.precoTarifado = precoTarifado;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }
}