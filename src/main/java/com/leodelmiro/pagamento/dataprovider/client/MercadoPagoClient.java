package com.leodelmiro.pagamento.dataprovider.client;

import com.leodelmiro.pagamento.dataprovider.client.request.MercadoPagoRequest;
import com.leodelmiro.pagamento.dataprovider.client.response.QrCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "mercadoPagoClient", url = "${external-apis.mercadopago.url}")
public interface MercadoPagoClient {
    @PostMapping("instore/orders/qr/seller/collectors/{vendedorId}/pos/{caixaId}/qrs")
    QrCodeResponse gerarQrCode(@PathVariable String vendedorId,
                               @PathVariable String caixaId,
                               @RequestHeader String authorization,
                               @RequestBody MercadoPagoRequest mercadoPagoRequest);
}
