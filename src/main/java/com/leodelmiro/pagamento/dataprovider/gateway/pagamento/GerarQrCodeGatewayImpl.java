package com.leodelmiro.pagamento.dataprovider.gateway.pagamento;

import com.leodelmiro.pagamento.core.dataprovider.pagamento.GerarQrCodeGateway;
import com.leodelmiro.pagamento.core.domain.ItemPedido;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.dataprovider.client.MercadoPagoClient;
import com.leodelmiro.pagamento.dataprovider.client.request.MercadoPagoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GerarQrCodeGatewayImpl implements GerarQrCodeGateway {

    @Autowired
    MercadoPagoClient client;

    @Value("${external-apis.mercadopago.vendedor-id}")
    private String vendedorId;

    @Value("${external-apis.mercadopago.caixa-id}")
    private String caixaId;

    // TODO PARA O AMBIENTE DE TESTE DA API É FIXO, PORÉM ALTERAR EM PROD PARA GERAÇÃO COM CLIENT ID E SECRET
    @Value("${external-apis.mercadopago.token}")
    private String token;

    @Override
        public String gerar(OrdemPagamento ordemPagamentoAGerarQrCode, List<ItemPedido> itensPedido) {

        var pedidoRequest = new MercadoPagoRequest(ordemPagamentoAGerarQrCode, itensPedido);
        var response = client.gerarQrCode(vendedorId, caixaId, "Bearer " + token, pedidoRequest);
        return response.qrData();
    }
}
