package com.deliverycompany.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem { // Classe para criar uma mensagem de erro

    private Integer status;
    private OffsetDateTime dateHour; // OffsetDateTime = adiciona o UTC no final da data/hora
    private String title;
    private List<Warnings> warnings;

    @AllArgsConstructor
    @Getter
    public static class Warnings {

        private String field_name;
        private String warning_message;
    }
}
