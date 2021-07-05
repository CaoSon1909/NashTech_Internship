package com.example.thirdtryspringbootapplication.config;

import com.example.thirdtryspringbootapplication.entity.EmployeeEntity;
import com.example.thirdtryspringbootapplication.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Configuration
public class EmployeeConfig {
    //Testing api
    @Bean
    CommandLineRunner cmd(EmployeeService service){
        return args -> {
        };
    }
}
