package com.leodelmiro.pagamento.core.usecase.pagamento;

import java.time.LocalDateTime;

public interface PagaPedidoUseCase {
    void pagar(String idOrdemPagamento, LocalDateTime pagoEm);
}
