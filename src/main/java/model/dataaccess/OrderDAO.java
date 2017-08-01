package model.dataaccess;

import model.entities.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static main.MainClass.factory;


public class OrderDAO implements IOrderDAO {

    /**
     * DAO class for Order entity that implements IOrderDAO which defines CRUD operations
     */

    public OrderDAO() {
    }

    /**
     * method that return a list of Order objects with data from DB
     *
     * @return List<Order>
     */

    public ArrayList<Order> getAll() {
        Session session = factory.openSession();
        List orders = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            orders = session.createQuery("from model.entities.Order").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (ArrayList<Order>) orders;
    }

    /**
     * method that returns an abject of type Order with data from DB
     *
     * @param id
     * @return Order
     */

    public Order getById(int id) {
        Session session = factory.openSession();
        Order order = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            order = session.load(Order.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }

    /**
     * method that adds data in DB
     *
     * @param order
     */

    public void add(Order order) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer orderID = null;
        try {
            tx = session.beginTransaction();
            orderID = (Integer) session.save(order);
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
     * @param order
     */

    public void update(Order order) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(order);
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
     * @param order
     */

    public void delete(Order order) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
