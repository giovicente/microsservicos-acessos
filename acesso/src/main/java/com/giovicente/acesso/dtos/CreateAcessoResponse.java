package com.giovicente.acesso.dtos;

public class CreateAcessoResponse {

    private long portaId;

    private long clienteId;

    public CreateAcessoResponse() { }

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
