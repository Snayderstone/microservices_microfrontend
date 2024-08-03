package com.example.demo;

import com.netflix.discovery.EurekaNamespace;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
//@OpenAPIDefinition(
//        info = @Info(title = "Customer OPEN API",version = "1.0.0", description = "Customer OPEN API documentation"),
// servers = @Server( description = "Customer OPEN API url")
//)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

}
