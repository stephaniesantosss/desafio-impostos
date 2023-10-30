package com.desafio.impostos.service;

import com.desafio.impostos.core.service.AutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class AutoServiceTest {

    @InjectMocks
    private AutoService autoService;

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(autoService, "iof", 0.01);
        ReflectionTestUtils.setField(autoService, "pis", 0.01);
        ReflectionTestUtils.setField(autoService, "cofins", 0.01);
    }

    @Test
    void deveCalcularTarifaAutoComSucesso() {
        var response = assertDoesNotThrow(() -> autoService.cotar(10.00));
        assertNotNull(response);
    }
}
