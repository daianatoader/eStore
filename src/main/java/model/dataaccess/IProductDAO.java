package model.dataaccess;

import model.entities.Product;

import java.util.List;

public interface IProductDAO {

    List<Product> getAll();

    Product getById(int id);

    void add(Product product);

    void update(Product product);

    void delete(Product product);
}