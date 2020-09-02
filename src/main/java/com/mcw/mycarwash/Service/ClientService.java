package com.mcw.mycarwash.Service;

import com.mcw.mycarwash.Model.Client;
import com.mcw.mycarwash.Model.Location;

import java.util.List;

public interface ClientService {

    List<Client> getClientList();

    Client get(String id);

    void saveClient(Client client);

    void deleteClient(String id);

    List<Client> getNearClientList(Location location);
}
