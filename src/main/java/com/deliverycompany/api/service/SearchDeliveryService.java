package com.deliverycompany.api.service;

import com.deliverycompany.api.domain.repository.DeliveryRepository;
import com.deliverycompany.api.exception.EntityNotFoundException;
import com.deliverycompany.api.model.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery search(Long deliveryId) { // Serviço para buscar um pedido a partir do ID
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(()-> new EntityNotFoundException("Delivery not found."));
        // Emite esta mensagem de erro caso não encontre nenhuma delivery no ID
    }

}
