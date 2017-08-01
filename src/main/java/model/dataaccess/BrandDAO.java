package model.dataaccess;

import model.entities.Brand;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static main.MainClass.factory;

/**
 * DAO class for Brand entity that implements IBrandDAO which defines CRUD operations
 */
public class BrandDAO implements IBrandDAO {


    public BrandDAO() {
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
        Brand brand = null;
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                brand = session.load(Brand.class, id);
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return brand;
    }

    /**
     * Method that returns a Brand based on a name
     *
     * @param name
     * @return
     */
    public Brand getByName(String name) {
        Brand brand = null;
        try {
            Session session = factory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                Query query = session.createQuery("from model.entities.Brand brand where brand.brandName = :name");
                query.setParameter("name", name);
                brand = (Brand) query.getSingleResult();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return brand;
    }

    /**
     * method that adds a new Brand object in DB
     *
     * @param brand
     */
    public void add(Brand brand) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(brand);
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
     * method that updates data based on ID
     *
     * @param brand
     */
    public void update(Brand brand) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.update(brand);
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
     * method that deletes a brand from DB based on ID
     *
     * @param brand
     */
    public void delete(Brand brand) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.delete(brand);
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