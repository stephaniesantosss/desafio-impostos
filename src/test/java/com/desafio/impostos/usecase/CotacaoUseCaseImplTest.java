package com.desafio.impostos.usecase;

import com.desafio.impostos.core.dto.CotacaoRequest;
import com.desafio.impostos.core.dto.CotacaoResponse;
import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.mapper.CotacaoMapper;
import com.desafio.impostos.core.mapper.SeguroMapper;
import com.desafio.impostos.core.model.Seguro;
import com.desafio.impostos.core.strategy.ProdutoFactoryStrategy;
import com.desafio.impostos.core.strategy.TarifaProduto;
import com.desafio.impostos.core.usecase.impl.CotacaoUseCaseImpl;
import com.desafio.impostos.dataprovider.SeguroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CotacaoUseCaseImplTest {

    @InjectMocks
    private CotacaoUseCaseImpl cotacaoUseCase;

    @Mock
    private ProdutoFactoryStrategy strategy;

    @Mock
    private SeguroMapper seguroMapper;

    @Mock
    private CotacaoMapper cotacaoMapper;

    @Mock
    private SeguroRepository seguroRepository;

    private CotacaoRequest cotacaoRequest;

    private CotacaoResponse cotacaoResponse;

    private Seguro seguro;

    private Double PRECO_TARIFADO;

    private Double PRECO_BASE;

    private String CATEGORIA;

    @BeforeEach
    void setup() {
        cotacaoRequest = new CotacaoRequest("Coatacao Teste", ProdutoEnum.AUTO, PRECO_BASE);
        cotacaoResponse = new CotacaoResponse("123", "Coatacao Teste", ProdutoEnum.AUTO.name(), PRECO_BASE, PRECO_TARIFADO);
        seguro = getSeguro();
        PRECO_TARIFADO = 100.00;
        CATEGORIA = "AUTO";
        PRECO_BASE = 80.00;
    }


    @Test
    void deveExecutarCotacaoComSucessoParaCotacaoExistente() {
        var tarifaProduto = mock(TarifaProduto.class);
        when(strategy.getProductStrategy(ProdutoEnum.AUTO)).thenReturn(tarifaProduto);
        when(tarifaProduto.cotar(any())).thenReturn(PRECO_TARIFADO);

        when(seguroMapper.toSeguro(cotacaoRequest, PRECO_TARIFADO)).thenReturn(seguro);
        when(cotacaoMapper.toCotacaoResponse(seguro)).thenReturn(cotacaoResponse);

        when(seguroRepository.save(any())).thenReturn(seguro);
        when(seguroRepository.findByCategoria(CATEGORIA)).thenReturn(Optional.of(new Seguro()));

        var response = assertDoesNotThrow(() -> cotacaoUseCase.execute(cotacaoRequest));
        assertNotNull(response);
    }

    @Test
    void deveExecutarCotacaoComSucessoParaCotacaoNaoExistente() {
        var tarifaProduto = mock(TarifaProduto.class);
        when(strategy.getProductStrategy(ProdutoEnum.AUTO)).thenReturn(tarifaProduto);
        when(tarifaProduto.cotar(any())).thenReturn(PRECO_TARIFADO);

        when(seguroMapper.toSeguro(cotacaoRequest, PRECO_TARIFADO)).thenReturn(seguro);
        when(cotacaoMapper.toCotacaoResponse(seguro)).thenReturn(cotacaoResponse);

        when(seguroRepository.save(any())).thenReturn(seguro);
        when(seguroRepository.findByCategoria(CATEGORIA)).thenReturn(Optional.empty());

        var response = assertDoesNotThrow(() -> cotacaoUseCase.execute(cotacaoRequest));
        assertNotNull(response);
    }

    private Seguro getSeguro() {
        return new Seguro("Teste", "CATEGORIA", PRECO_BASE, PRECO_TARIFADO);
    }
}
