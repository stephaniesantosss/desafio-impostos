package com.desafio.impostos.core.strategy;

import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.exception.CotacaoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoFactoryStrategy {

    private final List<TarifaProduto> tarifaProdutoList;

    public TarifaProduto getProductStrategy(ProdutoEnum produtoEnum) {
        return tarifaProdutoList.stream()
                .filter(strategy -> strategy.identify() == produtoEnum)
                .findFirst().orElseThrow(() -> new CotacaoException("Categoria nao encontrada para cotacao"));
    }
}
