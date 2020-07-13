package com.mcw.mycarwash.Service;

import com.mcw.mycarwash.Model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClientList();

    Client get(String id);

    void saveClient(Client client);

    void deleteClient(String id);
}
