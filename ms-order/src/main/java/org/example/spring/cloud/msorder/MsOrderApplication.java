package org.example.spring.cloud.msorder;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

    @PreDestroy
    public void method(){
        System.out.println("Before shutdown");
    }

}
