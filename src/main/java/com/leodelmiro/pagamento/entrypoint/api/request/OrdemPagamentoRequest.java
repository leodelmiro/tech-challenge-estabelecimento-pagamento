package com.leodelmiro.pagamento.entrypoint.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OrdemPagamentoRequest(
        @JsonProperty("id_pedido")
        String idPedido,
        @JsonProperty("preco_total")
        Double precoTotal,
        @JsonProperty("itens")
        List<ItemPedidoRequest> itens
) {}
