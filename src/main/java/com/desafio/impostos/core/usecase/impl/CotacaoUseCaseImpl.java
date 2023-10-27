package com.desafio.impostos.core.usecase.impl;

import com.desafio.impostos.core.dto.CotacaoRequest;
import com.desafio.impostos.core.dto.CotacaoResponse;
import com.desafio.impostos.core.mapper.CotacaoMapper;
import com.desafio.impostos.core.mapper.SeguroMapper;
import com.desafio.impostos.core.model.Seguro;
import com.desafio.impostos.core.strategy.ProdutoFactoryStrategy;
import com.desafio.impostos.core.usecase.CotacaoUseCase;
import com.desafio.impostos.dataprovider.SeguroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CotacaoUseCaseImpl implements CotacaoUseCase {


    private final ProdutoFactoryStrategy strategy;
    private final SeguroRepository seguroRepository;
    private final SeguroMapper seguroMapper;
    private final CotacaoMapper cotacaoMapper;

    @Override
    public CotacaoResponse execute(CotacaoRequest request) {

        var precoTarifado = strategy.getProductStrategy(request.categoria()).cotar(request.precoBase());
        var seguro = seguroMapper.toSeguro(request, precoTarifado);

        var seguroEntity = verificaCotacaoExistente(request, precoTarifado, seguro);

        return cotacaoMapper.toCotacaoResponse(seguroEntity);
    }

    private Seguro verificaCotacaoExistente(CotacaoRequest request, Double precoTarifado, Seguro seguro) {
        var entity = seguroRepository.findByCategoria(request.categoria().toString());

        if (entity.isEmpty()) {
            return seguroRepository.save(seguro);
        }

        entity.get().setPrecoTarifado(precoTarifado);
        entity.get().setPrecoBase(request.precoBase());
        return seguroRepository.save(entity.get());
    }
}
