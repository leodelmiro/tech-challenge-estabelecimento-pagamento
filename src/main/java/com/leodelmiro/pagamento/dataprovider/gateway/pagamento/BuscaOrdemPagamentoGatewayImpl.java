package com.leodelmiro.pagamento.dataprovider.gateway.pagamento;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.BuscaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.dataprovider.repository.OrdemPagamentoRepository;
import com.leodelmiro.pagamento.dataprovider.repository.entity.OrdemPagamentoEntity;
import com.leodelmiro.pagamento.dataprovider.repository.mapper.OrdemPagamentoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscaOrdemPagamentoGatewayImpl implements BuscaOrdemPagamentoGateway {

    @Autowired
    private OrdemPagamentoRepository ordemPagamentoRepository;

    @Autowired
    private OrdemPagamentoEntityMapper pedidoEntityMapper;

    @Override
    public OrdemPagamento buscar(String id) {
        OrdemPagamentoEntity ordemPagamento = ordemPagamentoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ordem de Pagamento não encontrada"));
        return pedidoEntityMapper.toOrdemPagamento(ordemPagamento);
    }

    @Override
    public OrdemPagamento buscarPorIdPedido(Long id) {
        OrdemPagamentoEntity ordemPagamento = ordemPagamentoRepository.findByIdPedido(id).orElseThrow(() -> new IllegalArgumentException("Ordem de Pagamento não encontrada"));
        return pedidoEntityMapper.toOrdemPagamento(ordemPagamento);
    }
}
