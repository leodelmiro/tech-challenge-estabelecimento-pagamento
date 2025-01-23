package com.leodelmiro.pagamento.dataprovider.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.leodelmiro.pagamento.config.LocalDateTimeConverter;

import java.time.LocalDateTime;

@DynamoDBTable(tableName ="tb_pagamento")
public class OrdemPagamentoEntity {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute
    private String qrCode;
    @DynamoDBAttribute
    private Long idPedido;
    @DynamoDBAttribute
    private Double precoTotal;
    @DynamoDBAttribute
    @DynamoDBTypeConverted( converter = LocalDateTimeConverter.class )
    private LocalDateTime pagoEm;
    @DynamoDBAttribute
    @DynamoDBTypeConverted( converter = LocalDateTimeConverter.class )
    private LocalDateTime criadoEm;

    public OrdemPagamentoEntity() {
    }

    public OrdemPagamentoEntity(String id, String qrCode, Long idPedido, Double precoTotal, LocalDateTime pagoEm, LocalDateTime criadoEm) {
        this.id = id;
        this.qrCode = qrCode;
        this.idPedido = idPedido;
        this.precoTotal = precoTotal;
        this.pagoEm = pagoEm;
        this.criadoEm = criadoEm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getPagoEm() {
        return pagoEm;
    }

    public void setPagoEm(LocalDateTime pagoEm) {
        this.pagoEm = pagoEm;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
