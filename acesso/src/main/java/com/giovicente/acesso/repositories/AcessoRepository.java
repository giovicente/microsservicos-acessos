package com.giovicente.acesso.repositories;

import com.giovicente.acesso.models.Acesso;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AcessoRepository extends CrudRepository<Acesso, Long> {

    Optional<Acesso> findByClienteIdAndPortaId(long clienteId, long portaId);

}
