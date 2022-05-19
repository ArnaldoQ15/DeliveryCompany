package com.deliverycompany.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientIdInput {

    @NotNull // Indica que não pode ser nulo
    private Long id;

}
