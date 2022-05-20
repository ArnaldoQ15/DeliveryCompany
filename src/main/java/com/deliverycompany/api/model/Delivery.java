package com.deliverycompany.api.model;

import com.deliverycompany.api.exception.BusinessException;
import com.deliverycompany.api.exception.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Indica que o Equals e o Hashcode precisam ser os mesmos APENAS nos marcados¹
@Entity // Setta a classe abaixo como sendo uma entidade que recebe os atributos dentro dela
public class Delivery {

    @EqualsAndHashCode.Include // Equals e Hashcode marcado¹
    @Id // Indica que essa variável é o ID único da classe
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que a ordem de geração de novos valores seguirá regras do BD
    private Long id;

    @Valid // Necessário colocar essa anotação pois a classe Delivery não cascateia para as demais a validação do Controller
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class) // Valida no momento do post, desobrigando
    // declarar itens desnecessários no JSON, por exemplo. Só funciona porque não é o Default
    @NotNull // Não permite que seja nulo
    @ManyToOne // Comando que significa "muitas entregas para o mesmo cliente" no caso abaixo
    private Client client;

    @Valid // Necessário colocar essa anotação pois a classe Delivery não cascateia para as demais a validação do Controller
    @NotNull // Não permite que seja nulo
    @Embedded // Comando para extrair todas as unidades da classe para uma mesma tabela, um bom uso da POO
    private Recipient recipient;

    @NotNull // Não permite que seja nulo
    private BigDecimal tax;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrences> occurrences = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Proibe o usuário de lançar este dado, ou seja, apenas leitura
    @Enumerated(EnumType.STRING) // Indica que queremos adicionar na tabela a String que representa a constante da operação
    private DeliveryStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Proibe o usuário de lançar este dado, ou seja, apenas leitura
    private OffsetDateTime requestDate; // OffsetDateTime = adiciona o UTC no final da data/hora

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Proibe o usuário de lançar este dado, ou seja, apenas leitura
    private OffsetDateTime requestDateFinished; // OffsetDateTime = adiciona o UTC no final da data/hora

    public Occurrences addOccurrence(String description) {
        Occurrences occurrences = new Occurrences();
        occurrences.setDescription((description));
        occurrences.setRegisterDate(OffsetDateTime.now());
        occurrences.setDelivery(this);

        this.getOccurrences().add(occurrences);

        return occurrences;
    }

    public void finish() { // Método para fazer a verificação booleana do status da entrega
        if (cantBeFinished()) {
            throw new BusinessException("The delivery can't be completed.");
        }

        setStatus(DeliveryStatus.FINISHED);
        setRequestDateFinished(OffsetDateTime.now());
    }

    // Verifica se pode ser finalizado
    public boolean canBeFinished() {
        return DeliveryStatus.PENDING.equals(getStatus());
    }

    // Verifica se NÃO pode ser finalizado
    public boolean cantBeFinished() {
        return !canBeFinished();
    }

}
