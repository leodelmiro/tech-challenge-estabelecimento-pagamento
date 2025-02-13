package com.leodelmiro.pagamento.entrypoint.controller;

import com.leodelmiro.pagamento.core.usecase.pagamento.PagaPedidoUseCase;
import com.leodelmiro.pagamento.entrypoint.api.request.MercadoPagoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.mockito.Mockito.*;

class WebhookControllerTest {

    private PagaPedidoUseCase pagaPedidoUseCase;
    private MercadoPagoRequest mercadoPagoRequest;

    @BeforeEach
    void setUp() {
        pagaPedidoUseCase = mock(PagaPedidoUseCase.class);
        mercadoPagoRequest = new MercadoPagoRequest(1L, true, "Test", OffsetDateTime.now(), 1L, "1", "Pagar", new MercadoPagoRequest.Data("12345"));
    }

    @Test
    void devePagar() {
        String signature = "test-signature";
        String id = "12345";

        WebhookController.pagar(signature, mercadoPagoRequest, pagaPedidoUseCase);

        verify(pagaPedidoUseCase, times(1)).pagar(id, mercadoPagoRequest.createdAt().toLocalDateTime());
    }
}