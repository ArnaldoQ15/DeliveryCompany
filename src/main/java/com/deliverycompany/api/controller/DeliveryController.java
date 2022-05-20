package com.deliverycompany.api.controller;

import com.deliverycompany.api.mapper.DeliveryMapper;
import com.deliverycompany.api.domain.repository.DeliveryRepository;
import com.deliverycompany.api.model.Delivery;
import com.deliverycompany.api.model.DeliveryResponse;
import com.deliverycompany.api.model.input.DeliveryInput;
import com.deliverycompany.api.service.DeliveryAlertService;
import com.deliverycompany.api.service.DeliveryFinishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryFinishService deliveryFinishService;
    private DeliveryRepository deliveryRepository;
    private DeliveryAlertService deliveryAlertService;
    private DeliveryMapper deliveryMapper;


    @PostMapping // Mapear o Post
    @ResponseStatus(HttpStatus.CREATED) // Resposta obtida caso seja bem-sucedido (201 - Created)
    public DeliveryResponse request(@Valid @RequestBody DeliveryInput deliveryInput) {
        Delivery newDelivery = deliveryMapper.toEntity(deliveryInput);
        Delivery deliveryRequested = deliveryAlertService.request(newDelivery);

        return deliveryMapper.toModel(deliveryRequested);
    }


    @GetMapping // Buscar todos os usuários (List All)
    public List<Delivery> listDeliveries() {
        return deliveryRepository.findAll();
    }


    @GetMapping("/{deliveryId}") // Buscar a partir do ID do cliente
    public ResponseEntity<DeliveryResponse> searchDeliveries(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());

                    /* Código BOILERPLATE (repetitivo) que é substituído por .api/mapper/DeliveryMapper
                    DeliveryResponse deliveryResponse = new DeliveryResponse();
                    deliveryResponse.setId(delivery.getId());
                    deliveryResponse.setClientName(delivery.getClient().getName());
                    deliveryResponse.setRecipient(new RecipientResponse());
                    deliveryResponse.getRecipient().setName(delivery.getRecipient().getName());
                    deliveryResponse.getRecipient().setStreet(delivery.getRecipient().getName());
                    deliveryResponse.getRecipient().setNumber(delivery.getRecipient().getNumber());
                    deliveryResponse.getRecipient().setComplement(delivery.getRecipient().getComplement());
                    deliveryResponse.getRecipient().setDistrict(delivery.getRecipient().getDistrict());
                    deliveryResponse.setTax(delivery.getTax());
                    deliveryResponse.setStatus(delivery.getStatus());
                    deliveryResponse.setRequestDate(delivery.getRequestDate());
                    deliveryResponse.setRequestDateFinished(delivery.getRequestDateFinished()); */
    }


    @PutMapping("/{deliveryId}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Long deliveryId) {
        deliveryFinishService.finish(deliveryId);
    }

}
