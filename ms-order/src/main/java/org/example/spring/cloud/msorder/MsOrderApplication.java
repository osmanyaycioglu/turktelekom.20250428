package org.example.spring.cloud.msorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import jakarta.annotation.PreDestroy;

@SpringBootApplication
@EnableDiscoveryClient
public class MsOrderApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

    @PreDestroy
    public void method() {
        System.out.println("Before shutdown");
    }

}
