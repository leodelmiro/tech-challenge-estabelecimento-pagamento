package com.leodelmiro.pagamento.core.usecase.pagamento.impl;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.GerarQrCodeGateway;
import com.leodelmiro.pagamento.core.dataprovider.pagamento.SalvaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.domain.ItemPedido;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CriaOrdemPagamentoUseCaseImplTest {

    private GerarQrCodeGateway gerarQrCodeGateway;
    private SalvaOrdemPagamentoGateway salvaOrdemPagamentoGateway;
    private CriaOrdemPagamentoUseCaseImpl criaOrdemPagamentoUseCase;

    @BeforeEach
    void setUp() {
        gerarQrCodeGateway = mock(GerarQrCodeGateway.class);
        salvaOrdemPagamentoGateway = mock(SalvaOrdemPagamentoGateway.class);
        criaOrdemPagamentoUseCase = new CriaOrdemPagamentoUseCaseImpl(gerarQrCodeGateway, salvaOrdemPagamentoGateway);
    }

    @Test
    void deveCriarOrdemPagamento() {
        OrdemPagamento ordemPagamento = new OrdemPagamento();
        List<ItemPedido> itensPedido = Collections.singletonList(new ItemPedido());
        OrdemPagamento savedOrdemPagamento = new OrdemPagamento();
        savedOrdemPagamento.setId(UUID.randomUUID().toString());

        String qrCode = "mockedQrCode";

        when(salvaOrdemPagamentoGateway.salvar(ordemPagamento)).thenReturn(savedOrdemPagamento);
        when(gerarQrCodeGateway.gerar(savedOrdemPagamento, itensPedido)).thenReturn(qrCode);
        when(salvaOrdemPagamentoGateway.salvar(savedOrdemPagamento)).thenReturn(savedOrdemPagamento);

        OrdemPagamento result = criaOrdemPagamentoUseCase.criar(ordemPagamento, itensPedido);

        assertEquals(savedOrdemPagamento, result);
        assertEquals(qrCode, result.getQrCode());

        verify(salvaOrdemPagamentoGateway, times(2)).salvar(any(OrdemPagamento.class));
        verify(gerarQrCodeGateway, times(1)).gerar(savedOrdemPagamento, itensPedido);
    }
}