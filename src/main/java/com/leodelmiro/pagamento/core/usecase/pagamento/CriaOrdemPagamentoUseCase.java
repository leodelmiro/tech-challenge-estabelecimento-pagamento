package com.leodelmiro.pagamento.core.usecase.pagamento;

import com.leodelmiro.pagamento.core.domain.ItemPedido;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;

import java.util.List;

public interface CriaOrdemPagamentoUseCase {
    OrdemPagamento criar(OrdemPagamento ordemPagamento, List<ItemPedido> itensPedido);
}
