package com.deliverycompany.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RecipientInput {

    @NotBlank // Não pode ficar em branco
    private String name;

    @NotBlank // Não pode ficar em branco
    private String street;

    @NotBlank // Não pode ficar em branco
    private String number;

    private String complement;

    @NotBlank // Não pode ficar em branco
    private String district;

}
