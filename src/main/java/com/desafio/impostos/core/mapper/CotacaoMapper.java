package com.desafio.impostos.core.mapper;

import com.desafio.impostos.core.dto.CotacaoResponse;
import com.desafio.impostos.core.model.Seguro;
import org.springframework.stereotype.Component;

@Component
public class CotacaoMapper {

    public CotacaoResponse toCotacaoResponse(Seguro seguro) {
        return new CotacaoResponse(seguro.getId(), seguro.getNome(), seguro.getCategoria(), seguro.getPrecoBase(), seguro.getPrecoTarifado());
    }
}
