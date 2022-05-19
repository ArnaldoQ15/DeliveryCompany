package com.deliverycompany.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable // Indica que a classe tem capacidade de ser utilizada com o "Embedded". Precisa haver na classe destino
public class Recipient {

    @NotBlank // Não pode ficar em branco
    @Column(name = "recipient_name") // Para indicar o nome da coluna no BD
    private String name;

    @NotBlank // Não pode ficar em branco
    @Column(name = "recipient_street") // Para indicar o nome da coluna no BD
    private String street;

    @NotBlank // Não pode ficar em branco
    @Column(name = "recipient_number") // Para indicar o nome da coluna no BD
    private String number;

    @Column(name = "recipient_complement") // Para indicar o nome da coluna no BD
    private String complement;

    @NotBlank // Não pode ficar em branco
    @Column(name = "recipient_district") // Para indicar o nome da coluna no BD
    private String district;

}
