package com.giovicente.acesso.clients;

import com.giovicente.acesso.models.Porta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "porta", configuration = PortaClientConfiguration.class)
public interface PortaClient {

    @GetMapping("/v1/porta/{id}")
    Porta consultarPortaPorId(@PathVariable long id);

}
