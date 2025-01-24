package com.leodelmiro.pagamento.core.dataprovider.pagamento;

import com.leodelmiro.pagamento.core.domain.OrdemPagamento;

public interface BuscaOrdemPagamentoGateway {
    OrdemPagamento buscar(String id);
}
