package bdd.utils;

import com.leodelmiro.pagamento.entrypoint.api.request.ItemPedidoRequest;
import com.leodelmiro.pagamento.entrypoint.api.request.MercadoPagoRequest;
import com.leodelmiro.pagamento.entrypoint.api.request.OrdemPagamentoRequest;

import java.time.OffsetDateTime;
import java.util.List;

public abstract class PagamentoHelper {
    public static OrdemPagamentoRequest gerarOrdemPagamentoRequest() {
        return new OrdemPagamentoRequest(
                "1",
                10.0,
                List.of(new ItemPedidoRequest(1L,
                        1L,
                        "BEBIDA",
                        "Teste",
                        "Teste",
                        10.0,
                        1,
                        10.0))
        );
    }
}
