package com.giovicente.acesso.controllers;

import com.giovicente.acesso.dtos.CreateAcessoRequest;
import com.giovicente.acesso.dtos.CreateAcessoResponse;
import com.giovicente.acesso.models.Acesso;
import com.giovicente.acesso.services.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sun.security.provider.certpath.OCSPResponse;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @PostMapping
    public ResponseEntity<CreateAcessoResponse> postAcesso(@RequestBody CreateAcessoRequest createAcessoRequest) {
        Acesso acesso = new Acesso();
        acesso.setPortaId(createAcessoRequest.getPortaId());
        acesso.setClienteId(createAcessoRequest.getClienteId());

        Acesso acessoObjeto = acessoService.salvarAcesso(acesso);

        CreateAcessoResponse createAcessoResponse = new CreateAcessoResponse();
        createAcessoResponse.setPortaId(acessoObjeto.getPortaId());
        createAcessoResponse.setClienteId(acessoObjeto.getClienteId());

        return ResponseEntity.status(201).body(createAcessoResponse);

    }

    @GetMapping("/{clienteId}/{portaId}")
    public CreateAcessoResponse getAcessoByIdClienteAndIdPorta(@PathVariable(name = "clienteId") long clienteId,
                                                               @PathVariable(name = "portaId") long portaId) {
        try {
            Acesso acessoObjeto = acessoService.consultarPorClienteIdEPortaId(clienteId, portaId);

            CreateAcessoResponse createAcessoResponse = new CreateAcessoResponse();
            createAcessoResponse.setPortaId(acessoObjeto.getPortaId());
            createAcessoResponse.setClienteId(acessoObjeto.getClienteId());

            return createAcessoResponse;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{clienteId}/{portaId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAcesso(@PathVariable(name = "clienteId") long clienteId,
                                                      @PathVariable(name = "portaId") long portaId) {

        acessoService.deletarPorClienteIdEPortaId(clienteId, portaId);

    }

}
