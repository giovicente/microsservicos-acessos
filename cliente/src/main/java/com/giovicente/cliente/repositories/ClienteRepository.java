package com.giovicente.cliente.repositories;

import com.giovicente.cliente.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> { }
