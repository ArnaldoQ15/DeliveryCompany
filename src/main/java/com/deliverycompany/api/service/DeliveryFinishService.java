package com.deliverycompany.api.service;

import com.deliverycompany.api.domain.repository.DeliveryRepository;
import com.deliverycompany.api.model.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service // Indica que é um classe de serviço. Essencial para evitar a declaração de códigos boilerplate
public class DeliveryFinishService {

    private DeliveryRepository deliveryRepository;
    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public void finish(Long deliveryId) { // Método para chamar a finalização de um pedido a partir do PUT no BD
        Delivery delivery = searchDeliveryService.search(deliveryId);

        delivery.finish();

        deliveryRepository.save(delivery);
    }

}
