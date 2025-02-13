package com.leodelmiro.pagamento.core.usecase.pagamento.impl;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.GerarQrCodeGateway;
import com.leodelmiro.pagamento.core.dataprovider.pagamento.SalvaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.domain.ItemPedido;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.core.usecase.pagamento.CriaOrdemPagamentoUseCase;

import java.util.List;

public class CriaOrdemPagamentoUseCaseImpl implements CriaOrdemPagamentoUseCase {

    private final GerarQrCodeGateway gerarQrCodeGateway;
    private final SalvaOrdemPagamentoGateway salvaOrdemPagamentoGateway;

    public CriaOrdemPagamentoUseCaseImpl(GerarQrCodeGateway gerarQrCodeGateway, SalvaOrdemPagamentoGateway salvaOrdemPagamentoGateway) {
        this.gerarQrCodeGateway = gerarQrCodeGateway;
        this.salvaOrdemPagamentoGateway = salvaOrdemPagamentoGateway;
    }

    @Override
    public OrdemPagamento criar(OrdemPagamento ordemPagamento, List<ItemPedido> itensPedido) {
        ordemPagamento = salvaOrdemPagamentoGateway.salvar(ordemPagamento);
        ordemPagamento.setQrCode(gerarQrCodeGateway.gerar(ordemPagamento, itensPedido));
        ordemPagamento = salvaOrdemPagamentoGateway.salvar(ordemPagamento);
        return ordemPagamento;
    }
}