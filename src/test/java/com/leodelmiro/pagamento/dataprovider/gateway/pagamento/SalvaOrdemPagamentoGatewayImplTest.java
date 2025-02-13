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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SalvaOrdemPagamentoGatewayImplTest {

    @Mock
    private OrdemPagamentoRepository ordemPagamentoRepository;

    @Mock
    private OrdemPagamentoEntityMapper ordemPagamentoEntityMapper;

    @InjectMocks
    private SalvaOrdemPagamentoGatewayImpl salvaOrdemPagamentoGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvar() {
        OrdemPagamento ordemPagamento = new OrdemPagamento();
        OrdemPagamentoEntity ordemPagamentoEntity = new OrdemPagamentoEntity();

        when(ordemPagamentoEntityMapper.toOrdemPagamentoEntity(any(OrdemPagamento.class)))
                .thenReturn(ordemPagamentoEntity);
        when(ordemPagamentoRepository.save(any(OrdemPagamentoEntity.class)))
                .thenReturn(ordemPagamentoEntity);
        when(ordemPagamentoEntityMapper.toOrdemPagamento(any(OrdemPagamentoEntity.class)))
                .thenReturn(ordemPagamento);

        OrdemPagamento result = salvaOrdemPagamentoGateway.salvar(ordemPagamento);

        assertEquals(ordemPagamento, result);
        verify(ordemPagamentoEntityMapper, times(1)).toOrdemPagamentoEntity(ordemPagamento);
        verify(ordemPagamentoRepository, times(1)).save(ordemPagamentoEntity);
        verify(ordemPagamentoEntityMapper, times(1)).toOrdemPagamento(ordemPagamentoEntity);
    }
}