package com.giovicente.acesso.clients;

import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class PortaClientConfiguration {

    @Bean
    public ErrorDecoder getErrorDecoder() { return new PortaClientDecoder(); }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators feignDecorators = FeignDecorators.builder()
                .withFallback(new PortaClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(feignDecorators);
    }

}
