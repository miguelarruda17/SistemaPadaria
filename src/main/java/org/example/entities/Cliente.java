package org.example.entities;

import javax.persistence.*;

@Entity
public class Cliente {

    //Atributos do java e do database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment.
    @Column(name = "ID", nullable = false)//nome no banco de dados.
    private Long idFormaPag; // nome no java.

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF")
    private String cpfCliente;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private String dataNascimento;

    @Column(name = "STATUS", nullable = false)
    private String statusCliente;


    public Cliente() {  }//Construtor vazio.

    //Construtor com argumentos(Construtor de inicialização de atributos do java).
    public Cliente(Long idFormaPag, String nome, String cpfCliente, String dataNascimento, String statusCliente) {
        this.idFormaPag = idFormaPag;
        this.nome = nome;
        this.cpfCliente = cpfCliente;
        this.dataNascimento = dataNascimento;
        this.statusCliente = statusCliente;
    }


    //GETTERS E SETTERS.
    public Long getIdFormaPag() {
        return idFormaPag;
    }

    public void setIdFormaPag(Long idFormaPag) {
        this.idFormaPag = idFormaPag;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(String statusCliente) {
        this.statusCliente = statusCliente;
    }
}
