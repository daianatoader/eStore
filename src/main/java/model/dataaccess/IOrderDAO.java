package model.dataaccess;

import model.entities.Order;

import java.util.ArrayList;

public interface IOrderDAO {

    ArrayList<Order> getAll();

    Order getById(int id);

    void add(Order order);

    void update(Order order);

    void delete(Order order);
}
