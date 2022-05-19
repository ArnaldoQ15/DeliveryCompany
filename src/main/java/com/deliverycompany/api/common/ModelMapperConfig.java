package com.deliverycompany.api.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Indica que é uma classe/arquivo de configurações
public class ModelMapperConfig {

    @Bean // Indica ao Spring para reconhecê-lo como um bean válido
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
