package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente implements Serializable {

    //Atributos do java e do database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment.
    @Column(name = "ID", nullable = false)//nome no banco de dados.
    private Long idCliente; // nome no java.

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF")
    private String cpfCliente;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private String dataNascimento;

    @Column(name = "STATUS", nullable = false)
    private String statusCliente;

    @OneToMany(mappedBy = "conCliente", cascade = CascadeType.ALL)
    private List<Contato> contato = new ArrayList<>();

    @OneToMany(mappedBy = "endCliente", cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<>();

    public Cliente() {  }//Construtor vazio.

    //Construtor com argumentos(Construtor de inicialização de atributos do java).
    public Cliente(Long idCliente, String nome, String cpfCliente, String dataNascimento, String statusCliente,Endereco endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpfCliente = cpfCliente;
        this.dataNascimento = dataNascimento;
        this.statusCliente = statusCliente;
    }


    //GETTERS E SETTERS.
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public List<Contato> getContato() {
        return contato;
    }

    public void setContato(List<Contato> contato) {
        this.contato = contato;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
