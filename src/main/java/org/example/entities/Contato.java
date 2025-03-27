package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {


    //Atributos do java e do database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment.
    @Column(name = "ID_Contato")//nome no banco de dados.
    private Long idContato; // nome no java.

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "CELULAR")
    private String celular;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    @JoinColumn(name = "CLIENTE", nullable = false)
    private Cliente cliente;


    public Contato() {  }//Construtor vazio.


    //Construtor com argumentos(Construtor de inicialização de atributos do java).


    public Contato(Long idContato, String telefone, String celular, String email, Cliente cliente) {
        this.idContato = idContato;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.cliente = cliente;
    }

    //GETTERS E SETTERS.


    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

}