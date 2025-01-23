package com.leodelmiro.pagamento.dataprovider.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leodelmiro.pagamento.core.domain.ItemPedido;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;

import java.util.List;

public class MercadoPagoRequest {
    @JsonProperty("external_reference")
    String externalReference;
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String description;
    @JsonProperty("total_amount")
    double totalAmount;
    @JsonProperty("items")
    List<ItemPedidoClientRequest> items;

    public MercadoPagoRequest(OrdemPagamento ordemPagamento, List<ItemPedido> itemPedidos) {
        this.externalReference = ordemPagamento.getIdPedido().toString();
        this.title = "Estabelecimento Fiap";
        this.description = "Pedido #" + ordemPagamento.getIdPedido() + "- Estabelecimento Fiap";
        this.totalAmount = ordemPagamento.getPrecoTotal();
        this.items = itemPedidos.stream().map(ItemPedidoClientRequest::new).toList();
    }

}
