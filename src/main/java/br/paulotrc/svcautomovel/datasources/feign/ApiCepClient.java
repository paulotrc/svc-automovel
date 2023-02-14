package br.paulotrc.svcautomovel.datasources.feign;

import br.paulotrc.svcautomovel.datasources.feign.configuration.apiCep.ApiCepClientConfiguration;
import br.paulotrc.svcautomovel.entites.feign.ResponseApiCepData;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "apicep",
        url = "${cep.api.url}",
        configuration = ApiCepClientConfiguration.class
)
public interface ApiCepClient {

    @GetMapping("/{cep}.json")
    @Headers({"Content-Type: application/json"})
    ResponseApiCepData consultarPorCep(@PathVariable(name = "cep") String cep);

}
