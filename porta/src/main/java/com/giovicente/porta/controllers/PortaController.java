package com.giovicente.porta.controllers;

import com.giovicente.porta.dtos.CreateRequestPorta;
import com.giovicente.porta.exceptions.PortaNotFoundException;
import com.giovicente.porta.models.Porta;
import com.giovicente.porta.services.PortaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/porta")
public class PortaController {

    @Autowired
    private PortaService portaService;

    @PostMapping
    public ResponseEntity<Porta> postPorta(@RequestBody CreateRequestPorta createRequestPorta) {
        Porta porta = new Porta();

        porta.setAndar(createRequestPorta.getAndar());
        porta.setSala(createRequestPorta.getSala());

        Porta portaObjeto = portaService.salvarPorta(porta);

        return ResponseEntity.status(201).body(portaObjeto);
    }

    @GetMapping("/{id}")
    public Porta getPortaPorId(@PathVariable(name = "id") Long id) {
        try {
            Porta portaObjeto = portaService.consultarPortaPorId(id);
            return portaObjeto;
        } catch (PortaNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Porta não encontrada");
        }
    }

}
