package com.deliverycompany.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurrenceResponse {

    private Long id;
    private String description;
    private OffsetDateTime registerDate;

}
