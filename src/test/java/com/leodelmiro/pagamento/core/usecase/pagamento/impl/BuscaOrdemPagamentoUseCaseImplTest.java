package com.leodelmiro.pagamento.core.usecase.pagamento.impl;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.BuscaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BuscaOrdemPagamentoUseCaseImplTest {

    private BuscaOrdemPagamentoGateway buscaOrdemPagamentoGateway;
    private BuscaOrdemPagamentoUseCaseImpl buscaOrdemPagamentoUseCase;

    @BeforeEach
    void setUp() {
        buscaOrdemPagamentoGateway = mock(BuscaOrdemPagamentoGateway.class);
        buscaOrdemPagamentoUseCase = new BuscaOrdemPagamentoUseCaseImpl(buscaOrdemPagamentoGateway);
    }

    @Test
    void deveBuscarIdValido() {
        String id = "123";
        OrdemPagamento expectedOrdemPagamento = new OrdemPagamento();
        when(buscaOrdemPagamentoGateway.buscar(id)).thenReturn(expectedOrdemPagamento);

        OrdemPagamento result = buscaOrdemPagamentoUseCase.buscar(id);

        assertEquals(expectedOrdemPagamento, result);
        verify(buscaOrdemPagamentoGateway, times(1)).buscar(id);
    }

    @Test
    void deveLancarIllegalArgumentExceptionAoBuscarNull() {
        String id = null;
        when(buscaOrdemPagamentoGateway.buscar(null)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> buscaOrdemPagamentoUseCase.buscar(id));
        verify(buscaOrdemPagamentoGateway, never()).buscar(anyString());
    }

    @Test
    void deveLancarIllegalArgumentExceptionAoBuscarIdInexistente() {
        String id = "non-existent-id";
        when(buscaOrdemPagamentoGateway.buscar(id)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> buscaOrdemPagamentoUseCase.buscar(id));
        verify(buscaOrdemPagamentoGateway, times(1)).buscar(id);
    }
}