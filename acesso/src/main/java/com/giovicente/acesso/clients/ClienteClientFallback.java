package com.giovicente.acesso.clients;

import com.giovicente.acesso.models.Cliente;

public class ClienteClientFallback implements ClienteClient {

    @Override
    public Cliente consultarClientePorId(long id) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1);

        return cliente;
    }

}
