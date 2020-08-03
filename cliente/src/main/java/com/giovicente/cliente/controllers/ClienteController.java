package com.giovicente.cliente.controllers;

import com.giovicente.cliente.dtos.CreateRequestCliente;
import com.giovicente.cliente.exceptions.ClienteNotFoundException;
import com.giovicente.cliente.models.Cliente;
import com.giovicente.cliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> postCliente(@RequestBody CreateRequestCliente createRequestCliente) {

        Cliente cliente = new Cliente();
        cliente.setNome(createRequestCliente.getNome());

        Cliente clienteObjeto = clienteService.salvarCliente(cliente);

        return ResponseEntity.status(201).body(clienteObjeto);
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable(name = "id") Long id) {

        try {
            Cliente clienteObjeto = clienteService.consultarClientePorId(id);
            return clienteObjeto;
        } catch (ClienteNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
        }
    }

}
