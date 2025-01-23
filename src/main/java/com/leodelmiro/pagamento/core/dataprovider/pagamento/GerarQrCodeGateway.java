package com.leodelmiro.pagamento.core.dataprovider.pagamento;

import com.leodelmiro.pagamento.core.domain.ItemPedido;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;

import java.util.List;

public interface GerarQrCodeGateway {
    String gerar(OrdemPagamento ordemPagamento, List<ItemPedido> itensPedido);
}
