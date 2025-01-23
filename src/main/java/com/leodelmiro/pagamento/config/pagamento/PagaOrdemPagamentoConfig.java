package com.leodelmiro.pagamento.config.pagamento;

import com.leodelmiro.pagamento.core.usecase.pagamento.impl.PagaOrdemPagamentoImpl;
import com.leodelmiro.pagamento.dataprovider.gateway.pagamento.SalvaOrdemPagamentoGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagaOrdemPagamentoConfig {

    @Bean
    public PagaOrdemPagamentoImpl pagaOrdemPagamentoUseCase(
            SalvaOrdemPagamentoGatewayImpl salvaOrdemPamentoGateway
    ) {
        return new PagaOrdemPagamentoImpl(salvaOrdemPamentoGateway);
    }
}
