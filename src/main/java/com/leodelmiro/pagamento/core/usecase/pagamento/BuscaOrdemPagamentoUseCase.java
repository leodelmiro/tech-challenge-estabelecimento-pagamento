package com.leodelmiro.pagamento.core.usecase.pagamento;

import com.leodelmiro.pagamento.core.domain.OrdemPagamento;

public interface BuscaOrdemPagamentoUseCase {
    OrdemPagamento buscar(String id);
}
