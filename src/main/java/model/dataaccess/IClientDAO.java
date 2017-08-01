package model.dataaccess;

import model.entities.Client;

import java.util.ArrayList;

public interface IClientDAO {

    ArrayList<Client> getAll();

    Client getById(int id);

    void add(Client client);

    void update(Client client);

    void delete(Client client);
}