package com.leodelmiro.pagamento.core.dataprovider.pagamento;

import com.leodelmiro.pagamento.core.domain.OrdemPagamento;

public interface SalvaOrdemPagamentoGateway {
    OrdemPagamento salvar(OrdemPagamento ordemPagamento);
}
