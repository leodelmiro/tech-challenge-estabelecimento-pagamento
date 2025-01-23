package com.leodelmiro.pagamento.core.usecase.pagamento;

import java.time.LocalDateTime;

public interface PagaPedidoUseCase {
    void pagar(Long idPedido, LocalDateTime pagoEm);
}
