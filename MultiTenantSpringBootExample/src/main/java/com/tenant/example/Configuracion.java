package com.tenant.example;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jhon
 */
@Configuration
public class Configuracion {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
        
    }
    
}
