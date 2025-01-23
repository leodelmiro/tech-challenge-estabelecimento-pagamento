package com.leodelmiro.pagamento.entrypoint.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leodelmiro.pagamento.core.domain.ItemPedido;

public record ItemPedidoRequest(
        @JsonProperty("id_item_pedido")
        Long idItemPedido,
        @JsonProperty("id_produto")
        Long idProduto,
        @JsonProperty("categoria")
        String categoria,
        @JsonProperty("nome")
        String nome,
        @JsonProperty("descricao")
        String descricao,
        @JsonProperty("preco_unitario")
        Double precoUnitario,
        @JsonProperty("quantidade")
        Integer quantidade,
        @JsonProperty("preco_total")
        Double precoTotal
) {

    public ItemPedido toItemPedido() {
        return new ItemPedido(
                this.idItemPedido,
                this.idProduto,
                this.categoria,
                this.nome,
                this.descricao,
                this.precoUnitario,
                this.quantidade,
                this.precoTotal
        );
    }

}
