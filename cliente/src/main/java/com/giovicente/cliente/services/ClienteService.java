package com.giovicente.cliente.services;

import com.giovicente.cliente.exceptions.ClienteNotFoundException;
import com.giovicente.cliente.models.Cliente;
import com.giovicente.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        Cliente clienteObjeto = clienteRepository.save(cliente);
        return clienteObjeto;
    }

    public Cliente consultarClientePorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        }

        throw new ClienteNotFoundException();
    }

}
