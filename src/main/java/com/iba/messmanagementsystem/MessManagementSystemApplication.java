package com.iba.messmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MessManagementSystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MessManagementSystemApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MessManagementSystemApplication.class);
    }

}
