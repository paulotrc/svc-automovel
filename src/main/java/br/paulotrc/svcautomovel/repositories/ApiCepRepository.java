package br.paulotrc.svcautomovel.repositories;

import br.paulotrc.svcautomovel.entites.feign.ResponseApiCepData;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

public interface ApiCepRepository {

    @CircuitBreaker(name = "processServiceApiCep", fallbackMethod = "fallback")
    @Retry(name = "default")
    ResponseApiCepData consultarPorCep(String cep);
}
