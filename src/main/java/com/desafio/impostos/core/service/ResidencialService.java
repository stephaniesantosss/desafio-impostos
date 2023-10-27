package com.desafio.impostos.core.service;

import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.strategy.TarifaProduto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ResidencialService implements TarifaProduto {

    @Value("${app.tarifas.residencial.iof}")
    private double iof;

    @Value("${app.tarifas.residencial.pis}")
    private double pis;

    @Value("${app.tarifas.residencial.cofins}")
    private double cofins;

    @Override
    public ProdutoEnum identify() {
        return ProdutoEnum.RESIDENCIAL;
    }

    @Override
    public Double cotar(Double precoBase) {
        return precoBase + (precoBase * iof) + (precoBase * pis) + (precoBase * cofins);
    }
}
