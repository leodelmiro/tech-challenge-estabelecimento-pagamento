package com.leodelmiro.pagamento.entrypoint.api;

import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.core.usecase.pagamento.BuscaOrdemPagamentoUseCase;
import com.leodelmiro.pagamento.core.usecase.pagamento.CriaOrdemPagamentoUseCase;
import com.leodelmiro.pagamento.entrypoint.api.mapper.OrdemPagamentoMapper;
import com.leodelmiro.pagamento.entrypoint.api.request.ItemPedidoRequest;
import com.leodelmiro.pagamento.entrypoint.api.request.OrdemPagamentoRequest;
import com.leodelmiro.pagamento.entrypoint.api.response.OrdemPagamentoResponse;
import com.leodelmiro.pagamento.entrypoint.controller.PagamentoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

class OrdemPagamentoApiTest {

    @InjectMocks
    private OrdemPagamentoApi ordemPagamentoApi;

    @Mock
    private CriaOrdemPagamentoUseCase criaOrdemPagamentoUseCase;

    @Mock
    private BuscaOrdemPagamentoUseCase buscaOrdemPagamentoUseCase;

    @Mock
    private PagamentoController pagamentoController;

    @Mock
    private OrdemPagamentoMapper ordemPagamentoMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriaOrdemPagamento() {
        OrdemPagamentoRequest ordemPagamentoRequest = new OrdemPagamentoRequest(
                "1",
                10.0,
                List.of(new ItemPedidoRequest(1L,
                        1L,
                        "BEBIDA",
                        "Test",
                        "Test",
                        10.0,
                        1,
                        10.0)));
        OrdemPagamentoResponse ordemPagamentoResponse = new OrdemPagamentoResponse("1",
                1L,
                "123",
                10.0,
                LocalDateTime.now(),
                null);
        when(criaOrdemPagamentoUseCase.criar(any(), any())).thenReturn(new OrdemPagamento("1",
                1L,
                "123",
                10.0,
                LocalDateTime.now(),
                null));

        ResponseEntity<OrdemPagamentoResponse> response = ordemPagamentoApi.cria(ordemPagamentoRequest);

        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testBuscaOrdemPagamento() {
        String id = "123";
        OrdemPagamentoResponse ordemPagamentoResponse = new OrdemPagamentoResponse("1", 1L, "123", 10.0, LocalDateTime.now(), LocalDateTime.now());
        when(buscaOrdemPagamentoUseCase.buscar("1")).thenReturn(new OrdemPagamento("1", 1L, "123", 10.0, LocalDateTime.now(), LocalDateTime.now()));

        ResponseEntity<OrdemPagamentoResponse> response = ordemPagamentoApi.busca(id);

        assertEquals(200, response.getStatusCode().value());
    }
}