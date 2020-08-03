package com.giovicente.cliente.models;

import javax.persistence.*;

@Entity
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    public Cliente() { }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

}
