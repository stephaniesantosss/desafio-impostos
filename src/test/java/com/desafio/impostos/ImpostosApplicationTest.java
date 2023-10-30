package com.desafio.impostos;

import com.desafio.impostos.core.dto.CotacaoRequest;
import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.entrypoint.CotacaoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class ImpostosApplicationTest {

    @Autowired
    private CotacaoController controller;

    @Test
    void testCalculaCotacaoProdutoAuto() {
        var response = assertDoesNotThrow(() -> controller.calculaCotacaoProduto(new CotacaoRequest("Seguro Individual Auto", ProdutoEnum.AUTO, 50.00)));
        assertNotNull(response);
        assertNotNull(Objects.requireNonNull(response.getBody()).id());
        assertNotNull(Objects.requireNonNull(response.getBody()).precoTarifado());
        assertEquals("AUTO", Objects.requireNonNull(response.getBody()).categoria());
        assertEquals(55.25, response.getBody().precoTarifado());
        assertEquals(50.00, response.getBody().precoBase());
        assertEquals("Seguro Individual Auto", response.getBody().nome());
    }

    @Test
    void testCalculaCotacaoProdutoVida() {
        var response = assertDoesNotThrow(() -> controller.calculaCotacaoProduto(new CotacaoRequest("Seguro Individual Vida", ProdutoEnum.VIDA, 100.00)));
        assertNotNull(response);
        assertNotNull(Objects.requireNonNull(response.getBody()).id());
        assertNotNull(Objects.requireNonNull(response.getBody()).precoTarifado());
        assertEquals("VIDA", Objects.requireNonNull(response.getBody()).categoria());
        assertEquals(106.00, response.getBody().precoTarifado());
        assertEquals(100.00, response.getBody().precoBase());
        assertEquals("Seguro Individual Vida", response.getBody().nome());
    }

    @Test
    void testCalculaCotacaoProdutoResidencial() {
        var response = assertDoesNotThrow(() -> controller.calculaCotacaoProduto(new CotacaoRequest("Seguro Individual Residencial", ProdutoEnum.RESIDENCIAL, 50.00)));
        assertNotNull(response);
        assertNotNull(Objects.requireNonNull(response.getBody()).id());
        assertNotNull(Objects.requireNonNull(response.getBody()).precoTarifado());
        assertEquals("RESIDENCIAL", Objects.requireNonNull(response.getBody()).categoria());
        assertEquals(54.75, response.getBody().precoTarifado());
        assertEquals(50.00, response.getBody().precoBase());
        assertEquals("Seguro Individual Residencial", response.getBody().nome());
    }

    @Test
    void testCalculaCotacaoProdutoPatrimonial() {
        var response = assertDoesNotThrow(() -> controller.calculaCotacaoProduto(new CotacaoRequest("Seguro Individual Patrimonial", ProdutoEnum.PATRIMONIAL, 10.00)));
        assertNotNull(response);
        assertNotNull(Objects.requireNonNull(response.getBody()).id());
        assertNotNull(Objects.requireNonNull(response.getBody()).precoTarifado());
        assertEquals("PATRIMONIAL", Objects.requireNonNull(response.getBody()).categoria());
        assertEquals(11.00, response.getBody().precoTarifado());
        assertEquals(10.00, response.getBody().precoBase());
        assertEquals("Seguro Individual Patrimonial", response.getBody().nome());
    }

    @Test
    void testCalculaCotacaoProdutoViagem() {
        var response = assertDoesNotThrow(() -> controller.calculaCotacaoProduto(new CotacaoRequest("Seguro Individual Viagem", ProdutoEnum.VIAGEM, 10.00)));
        assertNotNull(response);
        assertNotNull(Objects.requireNonNull(response.getBody()).id());
        assertNotNull(Objects.requireNonNull(response.getBody()).precoTarifado());
        assertEquals("VIAGEM", Objects.requireNonNull(response.getBody()).categoria());
        assertEquals(10.70, response.getBody().precoTarifado());
        assertEquals(10.00, response.getBody().precoBase());
        assertEquals("Seguro Individual Viagem", response.getBody().nome());
    }
}
