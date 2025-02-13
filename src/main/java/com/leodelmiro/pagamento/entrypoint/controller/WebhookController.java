package com.leodelmiro.pagamento.entrypoint.controller;

import com.leodelmiro.pagamento.core.usecase.pagamento.PagaPedidoUseCase;
import com.leodelmiro.pagamento.entrypoint.api.request.MercadoPagoRequest;

public class WebhookController {

    public static void pagar(String signature,
                             MercadoPagoRequest mercadoPagoRequest,
                             PagaPedidoUseCase pagaPedidoUseCase) {
        pagaPedidoUseCase.pagar(mercadoPagoRequest.data().id(), mercadoPagoRequest.createdAt().toLocalDateTime());
    }
}
