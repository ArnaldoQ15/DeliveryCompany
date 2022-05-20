package com.deliverycompany.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientResponse { // Essa classe serve para utilizar apenas os dados abaixo elencados ao ser chamada

    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;

}
