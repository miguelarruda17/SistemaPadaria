package org.example.entities;

import javax.persistence.*;

@Entity
public class Produto {

    //Atributos do java e do database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment.
    @Column(name = "ID", nullable = false)//nome no banco de dados.
    private Long idProduto; // nome no java.

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRECO_CUSTO")
    private Double precoCusto;

    @Column(name = "PRECO_VENDA")
    private Double precoVenda;

    @Column(name = "ESTOQUE")
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "FORNECEDOR", nullable = false)
    private Fornecedor fornecedor;

    public Produto() {  }


    public Produto(Long idProduto, String descricao, Double precoCusto, Double precoVenda, Integer estoque, Fornecedor fornecedor) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.fornecedor = fornecedor;
    }


    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
