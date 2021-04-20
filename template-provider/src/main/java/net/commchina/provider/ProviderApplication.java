package net.commchina.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

@EnableCircuitBreaker
@EnableFeignClients(basePackages = "net.commchina",defaultConfiguration = FeignClientsConfiguration.class)
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "net.commchina")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
