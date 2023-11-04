package com.example.modelmapper.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Component
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String password;
}