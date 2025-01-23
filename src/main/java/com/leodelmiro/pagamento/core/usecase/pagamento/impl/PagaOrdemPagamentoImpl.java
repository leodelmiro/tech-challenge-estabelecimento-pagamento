package com.leodelmiro.pagamento.core.usecase.pagamento.impl;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.SalvaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.usecase.pagamento.PagaPedidoUseCase;

import java.time.LocalDateTime;


public class PagaOrdemPagamentoImpl implements PagaPedidoUseCase {

    private final SalvaOrdemPagamentoGateway salvaOrdemPagamentoGateway;

    public PagaOrdemPagamentoImpl(SalvaOrdemPagamentoGateway salvaOrdemPagamentoGateway) {
        this.salvaOrdemPagamentoGateway = salvaOrdemPagamentoGateway;
    }

    @Override
    public void pagar(Long idPedido, LocalDateTime pagoEm) {
        /* TODO REFATORAR PARA FILA PARA SER CONSUMIDA NO PEDIDO*/
        /* TODO BUSCAR ID PAGAMENTO*/
        var pedido = buscaPedidoUseCase.buscar(idPedido);
        pedido.setPagoEm(pagoEm);
        pedido.avancarStatus();
        pagaPedidoGateway.pagar(pedido);
    }
}