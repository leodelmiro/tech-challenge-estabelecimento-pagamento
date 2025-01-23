package com.leodelmiro.pagamento.entrypoint.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leodelmiro.pagamento.core.domain.ItemPedido;
import com.leodelmiro.pagamento.dataprovider.client.request.ItemPedidoClientRequest;

import java.util.List;

public record OrdemPagamentoRequest(
        @JsonProperty("id_pedido")
        String idPedido,
        @JsonProperty("preco_total")
        Double precoTotal,
        @JsonProperty("items")
        List<ItemPedidoRequest> items
) {}
