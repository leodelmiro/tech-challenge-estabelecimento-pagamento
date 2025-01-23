package com.leodelmiro.pagamento.core.usecase.pagamento.impl;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.BuscaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.core.usecase.pagamento.BuscaOrdemPagamentoUseCase;

public class BuscaOrdemPagamentoUseCaseImpl implements BuscaOrdemPagamentoUseCase {

    private final BuscaOrdemPagamentoGateway buscaOrdemPagamentoGateway;

    public BuscaOrdemPagamentoUseCaseImpl(BuscaOrdemPagamentoGateway buscaPedidoGateway) {
        this.buscaOrdemPagamentoGateway = buscaPedidoGateway;
    }

    @Override
    public OrdemPagamento buscar(String id) {
        return buscaOrdemPagamentoGateway.buscar(id);
    }

}