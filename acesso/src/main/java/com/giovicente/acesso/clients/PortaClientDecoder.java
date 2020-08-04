package com.giovicente.acesso.clients;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PortaClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Porta não encontrada.");
        } else {
            return errorDecoder.decode(s, response);
        }
    }

}
