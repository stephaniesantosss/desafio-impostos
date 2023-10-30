package com.desafio.impostos.entrypoint;

import com.desafio.impostos.core.dto.CotacaoRequest;
import com.desafio.impostos.core.dto.CotacaoResponse;
import com.desafio.impostos.core.usecase.CotacaoUseCase;
import com.desafio.impostos.entrypoint.api.CotacaoControllerApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class CotacaoController implements CotacaoControllerApi {

    private final CotacaoUseCase cotacaoUseCase;

    @Override
    public ResponseEntity<CotacaoResponse> calculaCotacaoProduto(@Valid CotacaoRequest cotacaoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cotacaoUseCase.execute(cotacaoRequest));
    }
}
