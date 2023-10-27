package com.desafio.impostos.core.service;

import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.strategy.TarifaProduto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.desafio.impostos.core.enums.LogEnum.LOG_CALCULO_TARIFA_PATRIMONIAL_FIM;
import static com.desafio.impostos.core.enums.LogEnum.LOG_CALCULO_TARIFA_PATRIMONIAL_INCIO;

@Slf4j
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
        log.info(LOG_CALCULO_TARIFA_PATRIMONIAL_INCIO.getValue() + precoBase);

        var precoTarifado = precoBase + (precoBase * iof) + (precoBase * pis) + (precoBase * cofins);

        log.info(LOG_CALCULO_TARIFA_PATRIMONIAL_FIM.getValue() + precoTarifado);
        return precoTarifado;
    }
}
