package model.dataaccess;

import model.entities.Brand;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static main.MainClass.factory;

/**
 * DAO class for Brand entity that implements IBrandDAO which defines CRUD operations
 */
public class BrandDAO implements IBrandDAO {


    public BrandDAO() {
    }

    public static void getConfig() {
        try {
            factory = new Configuration().
                    configure().
                    addPackage("model.entities"). //add package if used.
                    addAnnotatedClass(Brand.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * method that selects all information from brand table
     *
     * @return List<Brand>
     */
    public List<Brand> getAll() {
        Session session = factory.openSession();
        List brands = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            brands = session.createQuery("from model.entities.Brand").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return brands;
    }

    /**
     * method that returns a Brand based on ID
     *
     * @param id
     * @return Brand
     */
    public Brand getById(int id) {
        Session session = factory.openSession();
        Brand brand = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            brand = session.load(Brand.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return brand;
    }

    /**
     * method that adds a new Brand object in DB
     *
     * @param brand
     */
    public void add(Brand brand) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Brand brandTmp = new Brand(brand.getBrandName(), brand.getDescription());
            brandTmp.setBrandName(brand.getBrandName());
            brandTmp.setDescription(brand.getDescription());
            session.save(brandTmp);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * method that updates data based on ID
     *
     * @param id
     * @param brand
     */
    public void update(int id, Brand brand) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Brand brandToUpdate = (Brand) session.get(Brand.class, id);
            brandToUpdate.setBrandName(brand.getBrandName());
            brandToUpdate.setDescription(brand.getDescription());
            session.update(brandToUpdate);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * method that deletes a brand from DB based on ID
     *
     * @param id
     */
    public void delete(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Brand brand =
                    (Brand) session.get(Brand.class, id);
            session.delete(brand);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}