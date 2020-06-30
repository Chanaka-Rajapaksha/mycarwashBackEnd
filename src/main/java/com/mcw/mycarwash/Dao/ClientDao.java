package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.Client;

import java.util.List;

public interface ClientDao {
    List<Client> getClientList();

    Client get(String id);

    void saveClient(Client client);

    void deleteClient(String id);
}
