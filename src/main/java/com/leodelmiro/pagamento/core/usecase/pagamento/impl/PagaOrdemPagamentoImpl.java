package com.leodelmiro.pagamento.core.usecase.pagamento.impl;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.PublicaMensagemPagamentoEfetuadoGateway;
import com.leodelmiro.pagamento.core.dataprovider.pagamento.SalvaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.usecase.pagamento.PagaPedidoUseCase;
import com.leodelmiro.pagamento.dataprovider.gateway.pagamento.BuscaOrdemPagamentoGatewayImpl;

import java.time.LocalDateTime;


public class PagaOrdemPagamentoImpl implements PagaPedidoUseCase {

    private final SalvaOrdemPagamentoGateway salvaOrdemPagamentoGateway;
    private final BuscaOrdemPagamentoGatewayImpl buscaOrdemPagamentoGateway;
    private final PublicaMensagemPagamentoEfetuadoGateway publicaMensagemPagamentoEfetuadoGateway;

    public PagaOrdemPagamentoImpl(SalvaOrdemPagamentoGateway salvaOrdemPagamentoGateway,
                                  BuscaOrdemPagamentoGatewayImpl buscaOrdemPagamentoGateway,
                                  PublicaMensagemPagamentoEfetuadoGateway publicaMensagemPagamentoEfetuadoGateway
    ) {
        this.salvaOrdemPagamentoGateway = salvaOrdemPagamentoGateway;
        this.buscaOrdemPagamentoGateway = buscaOrdemPagamentoGateway;
        this.publicaMensagemPagamentoEfetuadoGateway = publicaMensagemPagamentoEfetuadoGateway;
    }

    @Override
    public void pagar(String idOrdemPagamento, LocalDateTime pagoEm) {
        var ordemPagamento = buscaOrdemPagamentoGateway.buscar(idOrdemPagamento);
        ordemPagamento.setPagoEm(pagoEm);
        salvaOrdemPagamentoGateway.salvar(ordemPagamento);
        publicaMensagemPagamentoEfetuadoGateway.publicar(ordemPagamento.getIdPedido().toString());
    }
}