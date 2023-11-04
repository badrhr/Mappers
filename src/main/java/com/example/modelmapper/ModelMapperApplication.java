package com.example.modelmapper;

import com.example.modelmapper.dtos.CustomerDTO;
import com.example.modelmapper.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.modelmapper.mapper.ModelMapperConfig;
@SpringBootApplication
public class ModelMapperApplication {

    @Autowired
    private ModelMapperConfig customerMapper;

    public static void main(String[] args) {
        SpringApplication.run(ModelMapperApplication.class, args);
        System.out.println("Hello world");
    }

    @Bean
    CommandLineRunner start(){
        return args -> {
            Customer customer1 = Customer.builder().name("x").email("x@gmail.com").password("passwordx").build();
            Customer customer2 = Customer.builder().name("y").email("y@gmail.com").password("passwordz").build();
            Customer customer3 = Customer.builder().name("z").email("z@gmail.com").password("passwordz").build();
            CustomerDTO customerDTO = customerMapper.fromCustomer(customer1);
            System.out.println(customer1);
            System.out.println(customerDTO);

            System.out.println(
            "---------------------------"
            );

            List<Customer> customers = new ArrayList<>();
            customers.add(customer1);
            customers.add(customer2);
            customers.add(customer3);
            List<CustomerDTO> customerdtoslist =
                    customers.stream()
                            .map(customerMapper::fromCustomer).collect(Collectors.toList());
            System.out.println(customerdtoslist);

            };
    }
}