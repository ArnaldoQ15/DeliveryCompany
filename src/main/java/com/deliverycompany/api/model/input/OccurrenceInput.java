package com.deliverycompany.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrenceInput {

    @NotBlank // Não pode ser em branco
    private String description;

}
