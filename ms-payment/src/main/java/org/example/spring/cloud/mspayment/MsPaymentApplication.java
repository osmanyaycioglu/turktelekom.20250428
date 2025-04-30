package org.example.spring.cloud.mspayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPaymentApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsPaymentApplication.class,
                              args);
    }

}
