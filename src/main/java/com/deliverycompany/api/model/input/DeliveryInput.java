package com.deliverycompany.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryInput {

    @Valid // Verificar o cascateamento e a validade da informação
    @NotNull // Indica que não pode ser nulo
    private ClientIdInput client;

    @Valid // Verificar o cascateamento e a validade da informação
    @NotNull // Indica que não pode ser nulo
    private RecipientInput recipient;

    private BigDecimal tax;

}
