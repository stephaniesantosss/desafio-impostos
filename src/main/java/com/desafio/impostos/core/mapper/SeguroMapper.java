package com.desafio.impostos.core.mapper;

import com.desafio.impostos.core.dto.CotacaoRequest;
import com.desafio.impostos.core.model.Seguro;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class SeguroMapper {

    public Seguro toSeguro(CotacaoRequest request, Double precoTarifado) {
        return new Seguro(request.nome(), request.categoria().toString().toUpperCase(Locale.ROOT), request.precoBase(), precoTarifado);
    }
}
