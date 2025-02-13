package com.leodelmiro.pagamento.core.usecase.pagamento.impl;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.PublicaMensagemPagamentoEfetuadoGateway;
import com.leodelmiro.pagamento.core.dataprovider.pagamento.SalvaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.dataprovider.gateway.pagamento.BuscaOrdemPagamentoGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class PagaOrdemPagamentoImplTest {

    private SalvaOrdemPagamentoGateway salvaOrdemPagamentoGateway;
    private BuscaOrdemPagamentoGatewayImpl buscaOrdemPagamentoGateway;
    private PublicaMensagemPagamentoEfetuadoGateway publicaMensagemPagamentoEfetuadoGateway;
    private PagaOrdemPagamentoImpl pagaOrdemPagamento;

    @BeforeEach
    void setUp() {
        salvaOrdemPagamentoGateway = mock(SalvaOrdemPagamentoGateway.class);
        buscaOrdemPagamentoGateway = mock(BuscaOrdemPagamentoGatewayImpl.class);
        publicaMensagemPagamentoEfetuadoGateway = mock(PublicaMensagemPagamentoEfetuadoGateway.class);
        pagaOrdemPagamento = new PagaOrdemPagamentoImpl(
                salvaOrdemPagamentoGateway,
                buscaOrdemPagamentoGateway,
                publicaMensagemPagamentoEfetuadoGateway
        );
    }

    @Test
    void deveAtualizarOrdemPagamentoEPublicarMensagem() {
        String idOrdemPagamento = "123";
        LocalDateTime pagoEm = LocalDateTime.now();
        Long idPedido = 1L;

        OrdemPagamento ordemPagamento = new OrdemPagamento();
        ordemPagamento.setId(idOrdemPagamento);
        ordemPagamento.setIdPedido(idPedido);

        when(buscaOrdemPagamentoGateway.buscar(idOrdemPagamento)).thenReturn(ordemPagamento);

        pagaOrdemPagamento.pagar(idOrdemPagamento, pagoEm);

        assertEquals(pagoEm, ordemPagamento.getPagoEm());
        verify(salvaOrdemPagamentoGateway, times(1)).salvar(ordemPagamento);
        verify(publicaMensagemPagamentoEfetuadoGateway, times(1)).publicar(idPedido.toString());
    }

    @Test
    void deveLancarIllegalArgumentExceptionQuandoIdNaoEncontrado() {
        String idOrdemPagamento = "123";
        when(buscaOrdemPagamentoGateway.buscar(idOrdemPagamento)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> pagaOrdemPagamento.pagar(idOrdemPagamento, LocalDateTime.now()));

        verifyNoInteractions(salvaOrdemPagamentoGateway);
        verifyNoInteractions(publicaMensagemPagamentoEfetuadoGateway);
    }
}