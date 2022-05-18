package com.deliverycompany.api.controller;

import com.deliverycompany.api.domain.repository.ClientRepository;
import com.deliverycompany.api.model.Client;
import com.deliverycompany.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor // Torna o uso do código denso de construtores desnecessário, sendo preciso utilizar apenas
// este import do Lombok
@RestController // Indica que a classe é um controller em que os métodos "@RequestMapping" assumem a
// semântica @ResponseBody por padrão, atendendo à API REST
@RequestMapping("/clients") // Torna o uso do "@GetMapping ("/clients")" desnecessário porque mapeia todos
// os @GetMapping com o parâmetro fornecido
public class ClientController {


    /* Chamar o Repository (local de gerenciamento do Banco de Dados no Java) */
    private ClientRepository clientRepository;
    private ClientService clientService;


    /* Método para retornar a lista de todos os clientes do Repository */

    @GetMapping
    public List<Client> clientList() {
        return clientRepository.findAll();
    }


    /* Método para buscar o cliente a partir do ID no endpoint */
    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
        return clientRepository.findById(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    /* Método para adicionar o cliente no Banco de Dados */
    @PostMapping("/new") // Deve ser utilizado para métodos de POST
    @ResponseStatus(HttpStatus.CREATED) // Retorna a mensagem "201 - Created" caso seja bem-sucedido
    public Client addClient(@Valid @RequestBody Client client) {           // O "@RequestBody" vincula o
        // parâmetro do método ao corpo da requisição. O @Valid verifica se os parâmetros estão sendo seguidos
//        return clientRepository.save(client);   //    Formato básico, não serve para projetos grandes pois carece de regras de negócios
        return clientService.saveClient(client);
    }


    /* Método para atualizar um cliente no Banco de Dados */
    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@Valid @PathVariable Long clientId,
                                         @RequestBody Client client) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId); // Setta o ID do cliente no objeto a ser atualizado
//        client = clientRepository.save(client);   //    Formato básico, não serve para projetos grandes pois carece de regras de negócios
        client = clientService.saveClient(client);

        return ResponseEntity.ok(client);
    }


    /* Método para deletar um cliente no Banco de Dados */
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }
//        clientRepository.deleteById(clientId);   //    Formato básico, não serve para projetos grandes pois carece de regras de negócios
        clientService.deleteClient(clientId);

        return ResponseEntity.noContent().build();
    }

}
