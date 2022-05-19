package com.deliverycompany.api.mapper;

import com.deliverycompany.api.model.Delivery;
import com.deliverycompany.api.model.DeliveryResponse;
import com.deliverycompany.api.model.input.DeliveryInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component // Indica que esta classe é um componente que será gerenciado pelo Spring
public class DeliveryMapper {

    private ModelMapper modelMapper;

    public DeliveryResponse toModel(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryResponse.class);
    }

    public Delivery toEntity(DeliveryInput deliveryInput) {
        return modelMapper.map(deliveryInput, Delivery.class);
    }

}
