package com.deliverycompany.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientResponse {

    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;

}
