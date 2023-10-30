package com.desafio.impostos.service;

import com.desafio.impostos.core.service.ViagemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ViagemServiceTest {

    @InjectMocks
    private ViagemService viagemService;

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(viagemService, "iof", 0.01);
        ReflectionTestUtils.setField(viagemService, "pis", 0.01);
        ReflectionTestUtils.setField(viagemService, "cofins", 0.01);
    }

    @Test
    void deveCalcularTarifaViagemComSucesso() {
        var response = assertDoesNotThrow(() -> viagemService.cotar(10.00));
        assertNotNull(response);
    }
}
