package com.deliverycompany.api.service;

import com.deliverycompany.api.domain.repository.ClientRepository;
import com.deliverycompany.api.exception.BusinessException;
import com.deliverycompany.api.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service // É um componente spring que representa os serviços que serão executados onde executamos as regras de negócios
public class ClientService {

    private ClientRepository clientRepository;

    public Client searchClient(Long clientId) {
        return clientRepository.findById(clientId) // Busca o ID do cliente da entrega
                .orElseThrow(() -> new BusinessException("Client not found.")); // Caso seja inexistente = erro 400
    }

    @Transactional // Significa que se algo der errado, todas as operações feitas nesse objeto serão descartadas
    public Client saveClient(Client client) {
        boolean emailInUse = clientRepository.findByEmail(client.getEmail())
                .stream() // Permite executar várias tarefas de maneira mais simples
                .anyMatch(clientExist -> !clientExist.equals(client));

        if (emailInUse) { // Regra de negócio que proibe a criação de dois clientes com o mesmo endereço de e-mail
            throw new BusinessException(("There is already a client registered with this email."));
        }
        return clientRepository.save(client);
    }

    // O método abaixo exclui um cliente a partir do ID
    @Transactional
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

}
