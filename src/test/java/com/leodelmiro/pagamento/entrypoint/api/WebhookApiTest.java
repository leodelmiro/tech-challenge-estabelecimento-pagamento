package com.leodelmiro.pagamento.entrypoint.api;

import com.leodelmiro.pagamento.core.usecase.pagamento.PagaPedidoUseCase;
import com.leodelmiro.pagamento.entrypoint.api.request.MercadoPagoRequest;
import com.leodelmiro.pagamento.entrypoint.controller.WebhookController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebhookApiTest {

    @InjectMocks
    private WebhookApi webhookApi;

    @Mock
    private PagaPedidoUseCase pagaPedidoUseCase;

    @Mock
    private WebhookController webhookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarOkAoPpagamentoRealizado() {
        String signature = "test-signature";
        MercadoPagoRequest mercadoPagoRequest = new MercadoPagoRequest(1L,
                true,
                "Test",
                OffsetDateTime.now(),
                1L,
                "1",
                "Pagar",
                new MercadoPagoRequest.Data("12345"));

        ResponseEntity<Void> response = webhookApi.pagamentoRealizado(signature, mercadoPagoRequest);

        assertEquals(ResponseEntity.ok().build(), response);
    }
}