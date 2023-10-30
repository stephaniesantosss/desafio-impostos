package com.desafio.impostos;

import com.desafio.impostos.core.dto.CotacaoRequest;
import com.desafio.impostos.core.enums.ProdutoEnum;
import com.desafio.impostos.core.usecase.impl.CotacaoUseCaseImpl;
import com.desafio.impostos.entrypoint.CotacaoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImpostosApplicationTests {

	@Autowired
	private CotacaoController cotacaoController;

	@Autowired
	private CotacaoUseCaseImpl cotacaoUseCase;

	@Test
	public void contextLoads() throws Exception {
		cotacaoController.calculaCotacaoProduto(new CotacaoRequest("Test", ProdutoEnum.AUTO, 10.00));
	}

}
