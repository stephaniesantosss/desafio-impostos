package com.desafio.impostos.service;

import com.desafio.impostos.core.service.ResidencialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ResidencialServiceTest {

    @InjectMocks
    private ResidencialService residencialService;

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(residencialService, "iof", 0.01);
        ReflectionTestUtils.setField(residencialService, "pis", 0.01);
        ReflectionTestUtils.setField(residencialService, "cofins", 0.01);
    }

    @Test
    void deveCalcularTarifaResidencialComSucesso() {
        var response = assertDoesNotThrow(() -> residencialService.cotar(10.00));
        assertNotNull(response);
    }
}
