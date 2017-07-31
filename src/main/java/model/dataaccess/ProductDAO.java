package model.dataaccess;

import model.entities.Product;
import model.entities.Section;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static main.MainClass.factory;

/**
 * DAO class for Product entity that implements IProductDAO which defines CRUD operations
 */
public class ProductDAO implements IProductDAO {

    public ProductDAO() {
    }


    /**
     * method that return a list of Product objects with data from DB
     *
     * @return List<Product>
     */
    public List<Product> getAll() {
        Session session = factory.openSession();
        List products = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            products = session.createQuery("from model.entities.Product").list();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    /**
     * method that returns an abject of type Product with data from DB
     *
     * @param id
     * @return Product
     */
    public Product getById(int id) {
        Product product = null;
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                product = session.load(Product.class, id);
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    /**
     * method that adds data in DB
     *
     * @param product
     */
    public void add(Product product) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(product);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method that updates data in DB
     *
     * @param product
     */
    public void update(Product product) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.update(product);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method that deletes a field form Product table from DB
     *
     * @param product
     */
    public void delete(Product product) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.delete(product);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
