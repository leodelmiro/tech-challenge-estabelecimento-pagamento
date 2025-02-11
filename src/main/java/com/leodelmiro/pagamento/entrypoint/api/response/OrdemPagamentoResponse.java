package com.leodelmiro.pagamento.entrypoint.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leodelmiro.pagamento.dataprovider.client.request.ItemPedidoClientRequest;

import java.time.LocalDateTime;
import java.util.List;

public record   OrdemPagamentoResponse(
        @JsonProperty("id")
        String id,
        @JsonProperty("id_pedido")
        Long idPedido,
        @JsonProperty("qr_code")
        String qrCode,
        @JsonProperty("preco_total")
        Double precoTotal,
        @JsonProperty("criado_em")
        LocalDateTime criadoEm,
        @JsonProperty("pago_em")
        LocalDateTime pagoEm
) {}
