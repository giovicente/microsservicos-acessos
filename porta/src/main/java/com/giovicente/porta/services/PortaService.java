package com.giovicente.porta.services;

import com.giovicente.porta.exceptions.PortaNotFoundException;
import com.giovicente.porta.models.Porta;
import com.giovicente.porta.repositories.PortaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortaService {

    @Autowired
    private PortaRepository portaRepository;

    public Porta salvarPorta(Porta porta) {
        Porta portaObjeto = portaRepository.save(porta);
        return portaObjeto;
    }

    public Porta consultarPortaPorId(Long id) {
        Optional<Porta> portaOptional = portaRepository.findById(id);

        if (portaOptional.isPresent()) {
            return portaOptional.get();
        }

        throw new PortaNotFoundException();
    }

}
