package com.leodelmiro.pagamento.dataprovider.gateway.pagamento;

import com.leodelmiro.pagamento.config.SqsProperties;
import com.leodelmiro.pagamento.core.dataprovider.pagamento.PublicaMensagemPagamentoEfetuadoGateway;
import com.leodelmiro.pagamento.core.domain.OrdemPagamento;
import com.leodelmiro.pagamento.dataprovider.repository.OrdemPagamentoRepository;
import com.leodelmiro.pagamento.dataprovider.repository.mapper.OrdemPagamentoEntityMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicaMensagemPagamentoEfetuadoGatewayImpl implements PublicaMensagemPagamentoEfetuadoGateway {

    @Autowired
    private SqsTemplate sqsTemplate;

    @Autowired
    private SqsProperties sqsProperties;

    @Override
    public void publicar(String idPedido) {
        sqsTemplate.send(to -> to.queue(sqsProperties.getPagamentoEfetuado()).payload(idPedido));
    }
}
