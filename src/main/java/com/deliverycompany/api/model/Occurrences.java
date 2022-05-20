package com.deliverycompany.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity // NECESSÁRIO ADICIONAR ENTITY EM AMBOS OS MODELS CASO POSSUA @OneToMany
public class Occurrences {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Muitas Occurrences para apenas um Delivery
    private Delivery delivery;

    private String description;
    private OffsetDateTime registerDate; // OffsetDateTime inclui o fuso horário na declaração de horário

}
