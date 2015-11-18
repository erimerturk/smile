package com.smile.conf;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@ComponentScan(basePackages = {"com.smile.service", "com.smile.controller"})
@EnableTransactionManagement
@EnableAutoConfiguration
@Import(NeoConfig.class)
@Configuration
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);

    }


}
