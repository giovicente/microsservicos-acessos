package com.giovicente.acesso.services;

import com.giovicente.acesso.clients.ClienteClient;
import com.giovicente.acesso.clients.PortaClient;
import com.giovicente.acesso.models.Acesso;
import com.giovicente.acesso.models.Cliente;
import com.giovicente.acesso.models.Porta;
import com.giovicente.acesso.repositories.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;

    @Autowired
    private PortaClient portaClient;

    @Autowired
    private ClienteClient clienteClient;

    public Acesso salvarAcesso(Acesso acesso) {
        Porta portaObjeto = portaClient.consultarPortaPorId(acesso.getPortaId());
        Cliente clienteObjeto = clienteClient.consultarClientePorId(acesso.getClienteId());

        Acesso acessoObjeto = acessoRepository.save(acesso);

        return acessoObjeto;
    }

    public Acesso consultarPorClienteIdEPortaId(long clienteId, long portaId) {

        Cliente clienteObjeto = clienteClient.consultarClientePorId(clienteId);
        Porta portaObjeto = portaClient.consultarPortaPorId(portaId);

        Optional<Acesso> acessoOptional = acessoRepository.findByClienteIdAndPortaId(clienteId, portaId);

        if (acessoOptional.isPresent()) {
            return acessoOptional.get();
        }

        throw new RuntimeException("Acesso não encontrado.");
    }

}
