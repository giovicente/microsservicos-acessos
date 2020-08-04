package com.giovicente.acesso.clients;

import com.giovicente.acesso.models.Porta;

public class PortaClientFallback implements PortaClient {
    @Override
    public Porta consultarPortaPorId(long id) {
        Porta porta = new Porta();
        porta.setPortaId(1);

        return porta;
    }
}
