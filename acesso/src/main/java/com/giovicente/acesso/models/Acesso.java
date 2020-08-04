package com.giovicente.acesso.models;

import javax.persistence.*;

@Entity
@Table
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long portaId;

    private long clienteId;

    public Acesso() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPortaId() {
        return portaId;
    }

    public void setPortaId(long portaId) {
        this.portaId = portaId;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

}
