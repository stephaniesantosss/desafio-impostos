package com.desafio.impostos.service;

import com.desafio.impostos.core.service.VidaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class VidaServiceTest {

    @InjectMocks
    private VidaService vidaService;

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(vidaService, "iof", 0.01);
        ReflectionTestUtils.setField(vidaService, "pis", 0.01);
        ReflectionTestUtils.setField(vidaService, "cofins", 0.01);
    }

    @Test
    void deveCalcularTarifaVidaComSucesso() {
        var response = assertDoesNotThrow(() -> vidaService.cotar(10.00));
        assertNotNull(response);
    }
}
