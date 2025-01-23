package com.leodelmiro.pagamento.core.dataprovider.pagamento;

import com.leodelmiro.pagamento.core.domain.OrdemPagamento;

public interface SalvaOrdemPagamentoGateway {
    void salvar(OrdemPagamento ordemPagamento);
}
