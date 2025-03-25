package org.example.entities;

import javax.persistence.*;

@Entity
public class Fornecedor {

    //Atributos do java e do database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment.
    @Column(name = "ID", nullable = false)//nome no banco de dados.
    private Long idFornecedor; // nome no java.

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "STATUS")
    private String statusFornecedor;

    public Fornecedor() {  }

    public Fornecedor(Long idFornecedor, String razaoSocial, String nomeFantasia, String cnpj, String statusFornecedor) {
        this.idFornecedor = idFornecedor;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.statusFornecedor = statusFornecedor;
    }


    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStatusFornecedor() {
        return statusFornecedor;
    }

    public void setStatusFornecedor(String statusFornecedor) {
        this.statusFornecedor = statusFornecedor;
    }
}
