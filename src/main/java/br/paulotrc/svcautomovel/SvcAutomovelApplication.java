package br.paulotrc.svcautomovel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties
@EnableFeignClients
public class SvcAutomovelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvcAutomovelApplication.class, args);
    }

}
