package com.desafio.impostos.core.service;

import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.strategy.TarifaProduto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PatrimonialService implements TarifaProduto {

    @Value("${app.tarifas.patrimonial.iof}")
    private double iof;

    @Value("${app.tarifas.patrimonial.pis}")
    private double pis;

    @Value("${app.tarifas.patrimonial.cofins}")
    private double cofins;

    @Override
    public ProdutoEnum identify() {
        return ProdutoEnum.PATRIMONIAL;
    }

    @Override
    public Double cotar(Double precoBase) {
        return precoBase + (precoBase * iof) + (precoBase * pis) + (precoBase * cofins);
    }
}
