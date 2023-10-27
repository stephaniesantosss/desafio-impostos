package com.desafio.impostos.core.service;

import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.strategy.TarifaProduto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AutoService implements TarifaProduto {

    @Value("${app.tarifas.auto.iof}")
    private double iof;

    @Value("${app.tarifas.auto.pis}")
    private double pis;

    @Value("${app.tarifas.auto.cofins}")
    private double cofins;

    @Override
    public ProdutoEnum identify() {
        return ProdutoEnum.AUTO;
    }

    @Override
    public Double cotar(Double precoBase) {
        return precoBase + (precoBase * iof) + (precoBase * pis) + (precoBase * cofins);
    }
}
