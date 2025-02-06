package com.leodelmiro.pagamento.entrypoint.controller;

import com.leodelmiro.pagamento.core.usecase.pagamento.BuscaOrdemPagamentoUseCase;
import com.leodelmiro.pagamento.core.usecase.pagamento.CriaOrdemPagamentoUseCase;
import com.leodelmiro.pagamento.entrypoint.api.mapper.OrdemPagamentoMapper;
import com.leodelmiro.pagamento.entrypoint.api.request.ItemPedidoRequest;
import com.leodelmiro.pagamento.entrypoint.api.request.OrdemPagamentoRequest;
import com.leodelmiro.pagamento.entrypoint.api.response.OrdemPagamentoResponse;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.core.domain.ItemPedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PagamentoControllerTest {

    @Mock
    private CriaOrdemPagamentoUseCase criaOrdemPagamentoUseCase;

    @Mock
    private BuscaOrdemPagamentoUseCase buscaOrdemPagamentoUseCase;

    @Mock
    private OrdemPagamentoMapper ordemPagamentoMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarPagamento() {
        OrdemPagamentoRequest ordemPagamentoRequest = mock(OrdemPagamentoRequest.class);
        OrdemPagamento ordemPagamento = mock(OrdemPagamento.class);
        List<ItemPedidoRequest> itemPedidoRequests = List.of(mock(ItemPedidoRequest.class));
        List<ItemPedido> itemPedidos = List.of(mock(ItemPedido.class));
        OrdemPagamento ordemPagamentoCriada = mock(OrdemPagamento.class);
        OrdemPagamentoResponse ordemPagamentoResponse = mock(OrdemPagamentoResponse.class);

        when(ordemPagamentoRequest.itens()).thenReturn(itemPedidoRequests);
        when(ordemPagamentoMapper.toOrdemPagamento(ordemPagamentoRequest)).thenReturn(ordemPagamento);
        when(itemPedidoRequests.getFirst().toItemPedido()).thenReturn(itemPedidos.getFirst());
        when(criaOrdemPagamentoUseCase.criar(ordemPagamento, itemPedidos)).thenReturn(ordemPagamentoCriada);
        when(ordemPagamentoMapper.toOrdemPagamentoResponse(ordemPagamentoCriada)).thenReturn(ordemPagamentoResponse);

        OrdemPagamentoResponse result = PagamentoController.criar(ordemPagamentoRequest, criaOrdemPagamentoUseCase, ordemPagamentoMapper);

        assertEquals(ordemPagamentoResponse, result);
        verify(ordemPagamentoMapper).toOrdemPagamento(ordemPagamentoRequest);
        verify(criaOrdemPagamentoUseCase).criar(ordemPagamento, itemPedidos);
        verify(ordemPagamentoMapper).toOrdemPagamentoResponse(ordemPagamentoCriada);
    }

    @Test
    void deveBuscarPagamento() {
        String id = "123";
        OrdemPagamento ordemPagamento = mock(OrdemPagamento.class);
        OrdemPagamentoResponse ordemPagamentoResponse = mock(OrdemPagamentoResponse.class);

        when(buscaOrdemPagamentoUseCase.buscar(id)).thenReturn(ordemPagamento);
        when(ordemPagamentoMapper.toOrdemPagamentoResponse(ordemPagamento)).thenReturn(ordemPagamentoResponse);

        OrdemPagamentoResponse result = PagamentoController.buscar(id, buscaOrdemPagamentoUseCase, ordemPagamentoMapper);

        assertEquals(ordemPagamentoResponse, result);
        verify(buscaOrdemPagamentoUseCase).buscar(id);
        verify(ordemPagamentoMapper).toOrdemPagamentoResponse(ordemPagamento);
    }
}