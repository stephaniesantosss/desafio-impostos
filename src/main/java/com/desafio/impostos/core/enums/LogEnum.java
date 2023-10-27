package com.desafio.impostos.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LogEnum {
    LOG_COTACAO_USE_CASE_INICIO("CotacaoUseCaseImpl001 Inicio cotacao produto "),
    LOG_COTACAO_USE_CASE_FIM("CotacaoUseCaseImpl002 Fim cotacao produto "),
    LOG_COTACAO_USE_CASE_INICIO_COTACAO_EXISTENTE("CotacaoUseCaseImpl003 Inicio verificacao cotacao existente "),
    LOG_COTACAO_USE_CASE_COTACAO_NAO_EXISTENTE("CotacaoUseCaseImpl004 Cotacao nao existente, criando uma nova "),
    LOG_COTACAO_USE_CASE_FIM_COTACAO_EXISTENTE("CotacaoUseCaseImpl005 Fim verificacao cotacao existente, atualizando base "),
    LOG_CALCULO_TARIFA_AUTO_INCIO("CalculoTarifaAuto001 Inicio calculo tarifa AUTO preco base: "),
    LOG_CALCULO_TARIFA_AUTO_FIM("CalculoTarifaAuto002 Fim calculo tarifa AUTO preco tarifado: "),
    LOG_CALCULO_TARIFA_VIDA_INCIO("CalculoTarifaVida001 Inicio calculo tarifa VIDA preco base: "),
    LOG_CALCULO_TARIFA_VIDA_FIM("CalculoTarifaVida002 Fim calculo tarifa VIDA preco tarifado: "),
    LOG_CALCULO_TARIFA_PATRIMONIAL_INCIO("CalculoTarifaPatrimonial001 Inicio calculo tarifa PATRIMONIAL preco base: "),
    LOG_CALCULO_TARIFA_PATRIMONIAL_FIM("CalculoTarifaPatrimonial002 Fim calculo tarifa PATRIMONIAL preco tarifado: "),
    LOG_CALCULO_TARIFA_RESIDENCIAL_INCIO("CalculoTarifaResidencial001 Inicio calculo tarifa RESIDENCIAL preco base: "),
    LOG_CALCULO_TARIFA_RESIDENCIAL_FIM("CalculoTarifaResidencial002 Fim calculo tarifa RESIDENCIAL preco tarifado: "),
    LOG_CALCULO_TARIFA_VIAGEM_INCIO("CalculoTarifaViagem001 Inicio calculo tarifa VIAGEM preco base: "),
    LOG_CALCULO_TARIFA_VIAGEM_FIM("CalculoTarifaViagem002 Fim calculo tarifa VIAGEM preco tarifado: ");

    private final String value;
}
