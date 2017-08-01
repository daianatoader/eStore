package model.dataaccess;

import model.entities.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static main.MainClass.factory;

public class ClientDAO implements IClientDAO {

    /**
     * DAO class for Client entity that implements IClientDAO which defines CRUD operations
     */

    public ClientDAO() {
    }

    /**
     * method that return a list of Client objects with data from DB
     *
     * @return List<Client>
     */

    public ArrayList<Client> getAll() {
        Session session = factory.openSession();
        List clients = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            clients = session.createQuery("from model.entities.Client").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (ArrayList<Client>) clients;
    }

    /**
     * method that returns an abject of type Client with data from DB
     *
     * @param id
     * @return Client
     */

    public Client getById(int id) {
        Session session = factory.openSession();
        Client client = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            client = session.load(Client.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return client;
    }

    /**
     * method that adds data in DB
     *
     * @param client
     */

    public void add(Client client) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer clientID = null;
        try {
            tx = session.beginTransaction();
            clientID = (Integer) session.save(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /**
     * method that updates data in DB
     *
     * @param client
     */

    public void update(Client client) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /**
     * method that deletes a field form Product table from DB
     *
     * @param client
     */

    public void delete(Client client) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.delete(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
