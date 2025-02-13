package com.leodelmiro.pagamento.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "amazon.sqs")
public class SqsProperties {
    private String pagamentoEfetuado;

    public String getPagamentoEfetuado() {
        return pagamentoEfetuado;
    }

    public void setPagamentoEfetuado(String pagamentoEfetuado) {
        this.pagamentoEfetuado = pagamentoEfetuado;
    }
}