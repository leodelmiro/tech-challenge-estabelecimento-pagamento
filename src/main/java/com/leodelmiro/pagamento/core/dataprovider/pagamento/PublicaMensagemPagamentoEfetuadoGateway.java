package com.leodelmiro.pagamento.core.dataprovider.pagamento;

public interface PublicaMensagemPagamentoEfetuadoGateway {
    void publicar(String idPedido);
}
