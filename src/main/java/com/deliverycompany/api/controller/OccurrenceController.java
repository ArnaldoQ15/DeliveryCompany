package com.deliverycompany.api.controller;

import com.deliverycompany.api.mapper.OccurrenceMapper;
import com.deliverycompany.api.model.Delivery;
import com.deliverycompany.api.model.Occurrences;
import com.deliverycompany.api.model.OccurrenceResponse;
import com.deliverycompany.api.model.input.OccurrenceInput;
import com.deliverycompany.api.service.OccurrenceRegistryService;
import com.deliverycompany.api.service.SearchDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {

    private SearchDeliveryService searchDeliveryService;
    private OccurrenceRegistryService occurrenceRegistryService;
    private OccurrenceMapper occurrenceMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceResponse register(@PathVariable Long deliveryId,
                                       @Valid @RequestBody OccurrenceInput occurrenceInput) {
        Occurrences occurrencesRegistred = occurrenceRegistryService
                .register(deliveryId, occurrenceInput.getDescription());

        return occurrenceMapper.toModel(occurrencesRegistred);
    }

    @GetMapping
    public List<OccurrenceResponse> listOccurrences(@PathVariable Long deliveryId) {
        Delivery delivery = searchDeliveryService.search(deliveryId);

        return occurrenceMapper.toCollectionModel(delivery.getOccurrences());
    }

}
