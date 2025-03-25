package org.example.entities;

import javax.persistence.*;

@Entity
public class FormaPagamento {

    //Atributos do java e do database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment.
    @Column(name = "ID", nullable = false)//nome no banco de dados.
    private Long idFormaPag; // nome no java.

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "STATUS", nullable = false)
    private String status;


    public FormaPagamento() {  }//Construtor vazio.



    //Construtor com argumentos(Construtor de inicialização de atributos do java).
    public FormaPagamento(Long idFormaPag, String tipo, String descricao, String status) {
        this.idFormaPag = idFormaPag;
        this.tipo = tipo;
        this.descricao = descricao;
        this.status = status;
    }


    //GETTERS E SETTERS.


    public Long getIdFormaPag() {
        return idFormaPag;
    }

    public void setIdFormaPag(Long idFormaPag) {
        this.idFormaPag = idFormaPag;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

}