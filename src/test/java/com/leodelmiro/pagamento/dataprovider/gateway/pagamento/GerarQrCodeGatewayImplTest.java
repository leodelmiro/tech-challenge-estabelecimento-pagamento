package com.leodelmiro.pagamento.dataprovider.gateway.pagamento;

import com.leodelmiro.pagamento.core.domain.ItemPedido;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.dataprovider.client.MercadoPagoClient;
import com.leodelmiro.pagamento.dataprovider.client.request.MercadoPagoRequest;
import com.leodelmiro.pagamento.dataprovider.client.response.QrCodeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class GerarQrCodeGatewayImplTest {

    @Mock
    private MercadoPagoClient mercadoPagoClient;

    @InjectMocks
    private GerarQrCodeGatewayImpl gerarQrCodeGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(gerarQrCodeGateway, "vendedorId", "test-vendedor-id");
        ReflectionTestUtils.setField(gerarQrCodeGateway, "caixaId", "test-caixa-id");
        ReflectionTestUtils.setField(gerarQrCodeGateway, "token", "test-token");
    }

    @Test
    void deveGerarQrCode() {
        OrdemPagamento ordemPagamento = new OrdemPagamento(UUID.randomUUID().toString(),
                1L,
                "123",
                10.0,
                LocalDateTime.now(),
                null);
        List<ItemPedido> itensPedido = List.of(new ItemPedido(1L,
                1L,
                "BEBIDA",
                "Test",
                "Teste",
                10.0,
                1,
                10.0));

        QrCodeResponse mockResponse = mock(QrCodeResponse.class);
        when(mockResponse.qrData()).thenReturn("mock-qr-data");

        when(mercadoPagoClient.gerarQrCode(
                eq("test-vendedor-id"),
                eq("test-caixa-id"),
                eq("Bearer test-token"),
                any(MercadoPagoRequest.class)
        )).thenReturn(mockResponse);

        String qrCode = gerarQrCodeGateway.gerar(ordemPagamento, itensPedido);

        assertEquals("mock-qr-data", qrCode);

        ArgumentCaptor<MercadoPagoRequest> requestCaptor = ArgumentCaptor.forClass(MercadoPagoRequest.class);
        verify(mercadoPagoClient, times(1)).gerarQrCode(
                eq("test-vendedor-id"),
                eq("test-caixa-id"),
                eq("Bearer test-token"),
                requestCaptor.capture()
        );
    }
}