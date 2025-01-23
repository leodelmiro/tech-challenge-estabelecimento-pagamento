package com.leodelmiro.pagamento.core.domain;

import java.time.LocalDateTime;

public class OrdemPagamento {
    private String id;
    private Long idPedido;
    private String qrCode;
    private Double precoTotal;
    private LocalDateTime criadoEm;
    private LocalDateTime pagoEm;

    public OrdemPagamento() {
        criadoEm = LocalDateTime.now();
    }

    public OrdemPagamento(String id,
                          Long idPedido,
                          String qrCode,
                          Double precoTotal,
                          LocalDateTime criadoEm,
                          LocalDateTime pagoEm
    ) {
        if (qrCode.isBlank()) throw new IllegalArgumentException("QrCode não pode ser vazio");
        if (precoTotal == null || precoTotal < 0)
            throw new IllegalArgumentException("Preço deve ser igual ou maior que 0");

        this.id = id;
        this.idPedido = idPedido;
        this.qrCode = qrCode;
        this.precoTotal = precoTotal;
        this.criadoEm = (criadoEm == null) ? LocalDateTime.now() : criadoEm;
        this.pagoEm = pagoEm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
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

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getPagoEm() {
        return pagoEm;
    }

    public void setPagoEm(LocalDateTime pagoEm) {
        this.pagoEm = pagoEm;
    }
}
