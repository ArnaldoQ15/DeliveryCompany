package com.deliverycompany.api.service;

import com.deliverycompany.api.model.Delivery;
import com.deliverycompany.api.model.Occurrences;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class OccurrenceRegistryService {

    private SearchDeliveryService searchDeliveryService;

    @Transactional // Trata-se de uma transação, ou seja, se não resultar em sucesso tudo é revertido. Conceito de "rollback"
    public Occurrences register(Long deliveryId, String description) {
        Delivery delivery = searchDeliveryService.search(deliveryId);
        
        return delivery.addOccurrence(description);
    }

}
