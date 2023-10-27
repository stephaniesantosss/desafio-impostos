package com.desafio.impostos.entrypoint.api;

import com.desafio.impostos.core.dto.CotacaoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/seguros")
public interface CotacaoControllerApi {

    @PostMapping("/cotacao")
    ResponseEntity calculaCotacaoProduto(@RequestBody CotacaoRequest cotacaoRequest);
}
