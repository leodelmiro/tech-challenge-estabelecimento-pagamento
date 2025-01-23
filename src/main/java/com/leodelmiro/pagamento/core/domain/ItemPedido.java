package com.leodelmiro.pagamento.core.domain;

public class ItemPedido {
    Long idItemPedido;
    Long idProduto;
    String categoria;
    String nome;
    String descricao;
    Double precoUnitario;
    Integer quantidade;
    Double precoTotal;

    public ItemPedido() {
    }

    public ItemPedido(Long idItemPedido,
                      Long idProduto,
                      String categoria,
                      String nome,
                      String descricao,
                      Double precoUnitario,
                      Integer quantidade,
                      Double precoTotal) {
        this.idItemPedido = idItemPedido;
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
