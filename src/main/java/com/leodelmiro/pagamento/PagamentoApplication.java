package com.leodelmiro.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PagamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagamentoApplication.class, args);
    }
    /* TODO ADICIONAR COBERTURA DE TESTES 80% NA PIPELINE PARA DEV E INTEGRAÇÃO RODANDO PÓS DEV, GITHUB ACTIONS E INFRA SQS, REMOVER DEP DE SQL*/

}
