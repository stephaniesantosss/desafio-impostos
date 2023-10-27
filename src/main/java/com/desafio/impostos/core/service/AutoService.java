package com.desafio.impostos.core.service;

import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.strategy.TarifaProduto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.desafio.impostos.core.enums.LogEnum.LOG_CALCULO_TARIFA_AUTO_FIM;
import static com.desafio.impostos.core.enums.LogEnum.LOG_CALCULO_TARIFA_AUTO_INCIO;

@Slf4j
@Service
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
        log.info(LOG_CALCULO_TARIFA_AUTO_INCIO.getValue() + precoBase);

        var precoTarifado = precoBase + (precoBase * iof) + (precoBase * pis) + (precoBase * cofins);

        log.info(LOG_CALCULO_TARIFA_AUTO_FIM.getValue() + precoTarifado);
        return precoTarifado;
    }
}
