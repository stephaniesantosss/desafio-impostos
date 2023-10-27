package com.desafio.impostos.core.usecase;

import com.desafio.impostos.core.dto.CotacaoRequest;
import com.desafio.impostos.core.dto.CotacaoResponse;

public interface CotacaoUseCase {

    CotacaoResponse execute(CotacaoRequest cotacaoRequest);
}
