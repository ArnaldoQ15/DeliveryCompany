package com.deliverycompany.api.service;

import com.deliverycompany.api.domain.repository.DeliveryRepository;
import com.deliverycompany.api.model.Client;
import com.deliverycompany.api.model.Delivery;
import com.deliverycompany.api.model.DeliveryStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@AllArgsConstructor // Invoca os métodos de constructors padrões internamente, tornando-os desnecessários no código
@Service // Indica que é uma classe de serviço
public class DeliveryAlertService {

    private ClientService clientService; // Invoca o serviço de clientes cadastrados
    private DeliveryRepository deliveryRepository; // Invoca o repositório de entregas

    @Transactional
    public Delivery request(Delivery delivery) {
        Client client = clientService.searchClient(delivery.getClient().getId()); // Método de busca de usuário por ID

        delivery.setClient(client); // Setta o objeto cliente com os atributos criados para ser adicionado ao repositório
        delivery.setStatus(DeliveryStatus.PENDING); // Setta status padrão como pendente no ato de salvamento
        delivery.setRequestDate(OffsetDateTime.now()); // Setta a hora atual como padrão no ato de salvamento

        return deliveryRepository.save(delivery);
    }

}
