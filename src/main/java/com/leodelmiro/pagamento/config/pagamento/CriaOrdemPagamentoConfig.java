package com.leodelmiro.pagamento.config.pagamento;

import com.leodelmiro.pagamento.core.usecase.pagamento.impl.CriaOrdemPagamentoUseCaseImpl;
import com.leodelmiro.pagamento.dataprovider.gateway.pagamento.GerarQrCodeGatewayImpl;
import com.leodelmiro.pagamento.dataprovider.gateway.pagamento.SalvaOrdemPagamentoGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CriaOrdemPagamentoConfig {

    @Bean
    public CriaOrdemPagamentoUseCaseImpl criaOrdemPagamentoUseCase(GerarQrCodeGatewayImpl gerarQrCodeGateway, SalvaOrdemPagamentoGatewayImpl salvaOrdemPamentoGateway) {
        return new CriaOrdemPagamentoUseCaseImpl(gerarQrCodeGateway, salvaOrdemPamentoGateway);
    }
}
