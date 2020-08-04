package com.giovicente.acesso.dtos;

public class CreateAcessoRequest {

    private long portaId;

    private long clienteId;

    public CreateAcessoRequest() { }

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
