package com.leodelmiro.pagamento.dataprovider.gateway.pagamento;

import com.leodelmiro.pagamento.config.SqsProperties;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PublicaMensagemPagamentoEfetuadoGatewayImplTest {
    @Mock
    private SqsTemplate sqsTemplate;

    @Mock
    private SqsProperties sqsProperties;

    @InjectMocks
    private PublicaMensagemPagamentoEfetuadoGatewayImpl gateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void devePublicarMensagem() {
        String idPedido = "12345";
        String queueName = "pagamento-efetuado-queue";
        when(sqsProperties.getPagamentoEfetuado()).thenReturn(queueName);

        gateway.publicar(idPedido);

        verify(sqsTemplate, times(1)).send(any());
    }
}