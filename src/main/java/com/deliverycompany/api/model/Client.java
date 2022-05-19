package com.deliverycompany.api.model;

import com.deliverycompany.api.exception.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Indica que o Equals e o Hashcode precisam ser os mesmos APENAS nos marcados¹
@Getter
@Setter
@Entity // Setta a classe abaixo como sendo uma entidade que recebe os atributos dentro dela
@Table(name = "clients") // Nome da tabela no Banco de Dados
public class Client {


    @NotNull(groups = ValidationGroups.ClientId.class) // Proibe o usuário de deixar o valor em branco. O restante serve
    // para validar no momento do post, desobrigando declarar o ID no JSON, por exemplo. Só funciona porque não é o Default
    @EqualsAndHashCode.Include // Equals e Hashcode marcado¹
    @Id // Indica a variável que vai segurar o ID do usuário
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que a ordem de geração de novos valores seguirá regras do BD
    private Long id;


    @NotBlank // Não permite que seja enviado em branco nem nulo
    @Size(max = 80) // Tamanho máximo da variável no Banco de Dados
    @Column(name = "name") // Nome no banco de dados
    private String name;


    @NotBlank // Não permite que seja enviado em branco nem nulo
    @Size (max = 255) // Tamanho máximo da variável no Banco de Dados
    @Email // Verifica se tem a sintaxe correta de e-mail (@.com, etc)
    @Column(name = "email") // Nome no banco de dados
    private String email;


    @Column(name = "phone") // Nome no banco de dados
    private Long phone;

}
