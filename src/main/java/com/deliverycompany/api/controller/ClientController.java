package com.deliverycompany.api.controller;

import com.deliverycompany.api.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<Client> clientList() {
        var client1 = new Client();
        client1.setId(1L);
        client1.setName("Arnaldo Fagundes");
        client1.setPhone(7100000000L);
        client1.setEmail("arnaldo.s.fagundes@gmail.com");

        var client2 = new Client();
        client2.setId(2L);
        client2.setName("Testador Tester");
        client2.setPhone(7100000001L);
        client2.setEmail("usuariotestador@teste.com.br");

        return Arrays.asList(client1, client2);
    }
}
