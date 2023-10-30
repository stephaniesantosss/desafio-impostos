package com.desafio.impostos.controller;

import com.desafio.impostos.core.dto.CotacaoRequest;
import com.desafio.impostos.core.dto.CotacaoResponse;
import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.usecase.impl.CotacaoUseCaseImpl;
import com.desafio.impostos.entrypoint.CotacaoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CotacaoControllerTest {

    @InjectMocks
    private CotacaoController controller;

    private CotacaoRequest cotacaoRequest;

    private CotacaoResponse cotacaoResponse;

    private ResponseEntity responseEntity;

    @Mock
    private CotacaoUseCaseImpl cotacaoUseCase;

    @BeforeEach
    void setup() {
        cotacaoRequest = new CotacaoRequest("Coatacao Teste", ProdutoEnum.AUTO, 100.00);
        cotacaoResponse = new CotacaoResponse("123", "Coatacao Teste", ProdutoEnum.AUTO.name(), 100.00, 130.00);
        responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(cotacaoResponse);
    }

    @Test
    void deveRealizarCotacaoComSucesso() {
        when(cotacaoUseCase.execute(cotacaoRequest)).thenReturn(cotacaoResponse);
        var response = assertDoesNotThrow(() -> controller.calculaCotacaoProduto(cotacaoRequest));

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(responseEntity, response);
    }
}
