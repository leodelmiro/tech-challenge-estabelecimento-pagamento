package com.leodelmiro.pagamento.config.pagamento;

import com.leodelmiro.pagamento.core.usecase.pagamento.impl.BuscaOrdemPagamentoUseCaseImpl;
import com.leodelmiro.pagamento.dataprovider.gateway.pagamento.BuscaOrdemPagamentoGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscaOrdemPagamentoConfig {

    @Bean
    public BuscaOrdemPagamentoUseCaseImpl buscaOrdemPagamentoUseCase(
            BuscaOrdemPagamentoGatewayImpl buscaOrdemPagamentoGateway
    ) {
        return new BuscaOrdemPagamentoUseCaseImpl(buscaOrdemPagamentoGateway);
    }
}
