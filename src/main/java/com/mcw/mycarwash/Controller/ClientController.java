package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Model.Client;
import com.mcw.mycarwash.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliapi")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public List<Client> getClientList(){
        return  clientService.getClientList();
    }

    @PostMapping("/client")
    public Client save(@RequestBody Client client) {
        clientService.saveClient(client);
        return client;
    }
    @GetMapping("/client/{id}")
    public Client getCustomer(@PathVariable String id) {
        return clientService.get(id);
    }

    @DeleteMapping("/client/{id}")
    public String deleteCustomer(@PathVariable String id) {
        clientService.deleteClient(id);
        return "Client deleted" + id;
    }
}
