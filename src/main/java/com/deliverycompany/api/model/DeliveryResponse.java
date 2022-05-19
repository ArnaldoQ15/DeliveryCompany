package com.deliverycompany.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryResponse {

    private Long id;
    private ClientInfoResponse client;
    private RecipientResponse recipient;
    private BigDecimal tax;
    private DeliveryStatus status;
    private OffsetDateTime requestDate;
    private OffsetDateTime requestDateFinished;

}
