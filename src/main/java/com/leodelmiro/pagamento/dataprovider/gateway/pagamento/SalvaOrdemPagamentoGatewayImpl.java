package com.leodelmiro.pagamento.dataprovider.gateway.pagamento;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.SalvaOrdemPagamentoGateway;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.dataprovider.repository.OrdemPagamentoRepository;
import com.leodelmiro.pagamento.dataprovider.repository.mapper.OrdemPagamentoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvaOrdemPagamentoGatewayImpl implements SalvaOrdemPagamentoGateway {

    @Autowired
    private OrdemPagamentoRepository ordemPagamentoRepository;

    @Autowired
    private OrdemPagamentoEntityMapper ordemPagamentoEntityMapper;

    @Override
    public OrdemPagamento salvar(OrdemPagamento ordemPagamento) {
        var ordemEntity = ordemPagamentoEntityMapper.toOrdemPagamentoEntity(ordemPagamento);
        ordemPagamentoRepository.save(ordemEntity);
        return ordemPagamentoEntityMapper.toOrdemPagamento(ordemEntity);
    }
}
