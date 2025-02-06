package com.leodelmiro.pagamento.dataprovider.gateway.pagamento;

import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.dataprovider.repository.OrdemPagamentoRepository;
import com.leodelmiro.pagamento.dataprovider.repository.entity.OrdemPagamentoEntity;
import com.leodelmiro.pagamento.dataprovider.repository.mapper.OrdemPagamentoEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscaOrdemPagamentoGatewayImplTest {

    @Mock
    private OrdemPagamentoRepository ordemPagamentoRepository;

    @Mock
    private OrdemPagamentoEntityMapper pedidoEntityMapper;

    @InjectMocks
    private BuscaOrdemPagamentoGatewayImpl buscaOrdemPagamentoGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarPagamento() {
        String id = "123";
        OrdemPagamentoEntity ordemPagamentoEntity = new OrdemPagamentoEntity();
        OrdemPagamento ordemPagamento = new OrdemPagamento();

        when(ordemPagamentoRepository.findById(id)).thenReturn(Optional.of(ordemPagamentoEntity));
        when(pedidoEntityMapper.toOrdemPagamento(ordemPagamentoEntity)).thenReturn(ordemPagamento);

        OrdemPagamento result = buscaOrdemPagamentoGateway.buscar(id);

        assertNotNull(result);
        assertEquals(ordemPagamento, result);
        verify(ordemPagamentoRepository, times(1)).findById(id);
        verify(pedidoEntityMapper, times(1)).toOrdemPagamento(ordemPagamentoEntity);
    }

    @Test
    void deveLancarIllegalArgumentoExceptionQuandoPagamentoNãoEncontrado() {
        String id = "123";
        when(ordemPagamentoRepository.findById(id)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> buscaOrdemPagamentoGateway.buscar(id));
        assertEquals("Ordem de Pagamento não encontrada", exception.getMessage());
        verify(ordemPagamentoRepository, times(1)).findById(id);
        verifyNoInteractions(pedidoEntityMapper);
    }
}