package com.leodelmiro.pagamento.dataprovider.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leodelmiro.pagamento.core.domain.ItemPedido;

public class ItemPedidoClientRequest {
    @JsonProperty("sku_number")
    String skuNumber;
    @JsonProperty("category")
    String category;
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String description;
    @JsonProperty("unit_price")
    Double unitPrice;
    @JsonProperty("quantity")
    Integer quantity;
    @JsonProperty("unit_measure")
    String unitMeasure;
    @JsonProperty("total_amount")
    Double totalAmount;

    ItemPedidoClientRequest(ItemPedido itemPedido) {
        this.skuNumber = "ITEM" + itemPedido.getIdItemPedido().toString() + "PROD" + itemPedido.getIdProduto().toString();
        this.category = itemPedido.getCategoria();
        this.title = itemPedido.getNome();
        this.description = itemPedido.getDescricao();
        this.unitPrice = itemPedido.getPrecoUnitario();
        this.quantity = itemPedido.getQuantidade();
        this.unitMeasure = "unit";
        this.totalAmount = itemPedido.getPrecoTotal();
    }
}
