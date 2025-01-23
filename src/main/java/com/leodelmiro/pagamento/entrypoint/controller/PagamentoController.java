package com.leodelmiro.pagamento.entrypoint.controller;

import com.leodelmiro.pagamento.core.usecase.pagamento.BuscaOrdemPagamentoUseCase;
import com.leodelmiro.pagamento.core.usecase.pagamento.CriaOrdemPagamentoUseCase;
import com.leodelmiro.pagamento.entrypoint.api.mapper.OrdemPagamentoMapper;
import com.leodelmiro.pagamento.entrypoint.api.request.ItemPedidoRequest;
import com.leodelmiro.pagamento.entrypoint.api.request.OrdemPagamentoRequest;
import com.leodelmiro.pagamento.entrypoint.api.response.OrdemPagamentoResponse;

public class PagamentoController {

    public static OrdemPagamentoResponse criar(OrdemPagamentoRequest ordemPagamentoRequest,
                                               CriaOrdemPagamentoUseCase criaOrdemPagamentoUseCase,
                                               OrdemPagamentoMapper ordemPagamentoMapper) {
        var ordemPagamento = ordemPagamentoMapper.toOrdemPagamento(ordemPagamentoRequest);
        var itensPedido = ordemPagamentoRequest.items().stream().map(ItemPedidoRequest::toItemPedido).toList();
        var ordemPagamentoCriada = criaOrdemPagamentoUseCase.criar(ordemPagamento, itensPedido);
        return ordemPagamentoMapper.toOrdemPagamentoResponse(ordemPagamentoCriada);
    }

    public static OrdemPagamentoResponse buscar(final String id,
                                                BuscaOrdemPagamentoUseCase buscaOrdemPagamentoUseCase,
                                                OrdemPagamentoMapper ordemPagamentoMapper) {
        var ordemPagamento = buscaOrdemPagamentoUseCase.buscar(id);
        return ordemPagamentoMapper.toOrdemPagamentoResponse(ordemPagamento);
    }
}
