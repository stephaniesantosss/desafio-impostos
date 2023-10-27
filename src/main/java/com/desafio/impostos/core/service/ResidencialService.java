package com.desafio.impostos.core.service;

import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.strategy.TarifaProduto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.desafio.impostos.core.enums.LogEnum.LOG_CALCULO_TARIFA_RESIDENCIAL_INCIO;

@Slf4j
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
        log.info(LOG_CALCULO_TARIFA_RESIDENCIAL_INCIO.getValue() + precoBase);

        var precoTarifado = precoBase + (precoBase * iof) + (precoBase * pis) + (precoBase * cofins);

        log.info(LOG_CALCULO_TARIFA_RESIDENCIAL_INCIO.getValue() + precoTarifado);
        return precoTarifado;
    }
}
