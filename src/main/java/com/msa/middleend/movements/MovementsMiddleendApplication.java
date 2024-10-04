package com.msa.middleend.movements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovementsMiddleendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovementsMiddleendApplication.class, args);
    }

}
