package com.deliverycompany.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem { // Classe para criar uma mensagem de erro

    private Integer status;
    private LocalDateTime dateHour;
    private String title;
    private List<Warnings> warnings;

    @AllArgsConstructor
    @Getter
    public static class Warnings {

        private String field_name;
        private String warning_message;
    }
}
