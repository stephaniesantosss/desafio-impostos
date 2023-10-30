package com.desafio.impostos.service;

import com.desafio.impostos.core.service.PatrimonialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PatrimonialServiceTest {

    @InjectMocks
    private PatrimonialService patrimonialService;

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(patrimonialService, "iof", 0.01);
        ReflectionTestUtils.setField(patrimonialService, "pis", 0.01);
        ReflectionTestUtils.setField(patrimonialService, "cofins", 0.01);
    }

    @Test
    void deveCalcularTarifaPatrimonialComSucesso() {
        var response = assertDoesNotThrow(() -> patrimonialService.cotar(10.00));
        assertNotNull(response);
    }
}
