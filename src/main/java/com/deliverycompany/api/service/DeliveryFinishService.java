package com.deliverycompany.api.service;

import com.deliverycompany.api.domain.repository.DeliveryRepository;
import com.deliverycompany.api.model.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DeliveryFinishService {

    private DeliveryRepository deliveryRepository;
    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public void finish(Long deliveryId) {
        Delivery delivery = searchDeliveryService.search(deliveryId);

        delivery.finish();

        deliveryRepository.save(delivery);
    }

}
