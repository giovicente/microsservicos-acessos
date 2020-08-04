package com.giovicente.acesso.clients;

import com.giovicente.acesso.models.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente", configuration = ClienteClientConfiguration.class)
public interface ClienteClient {

    @GetMapping("/v1/cliente/{id}")
    Cliente consultarClientePorId(@PathVariable long id);

}
