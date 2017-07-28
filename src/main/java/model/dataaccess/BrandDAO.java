package model.dataaccess;

import model.entities.Brand;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import static main.MainClass.factory;


public class BrandDAO implements IBrandDAO{



    public BrandDAO(){}

    public static void getConfig(){
        try{
            factory = new Configuration().
                    configure().
                    addPackage("model.entities"). //add package if used.
                    addAnnotatedClass(Brand.class).
                    buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public ArrayList<Brand> getAll() {
        Session session = factory.openSession();
        List brands=null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            brands = session.createQuery("from model.entities.Brand").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return (ArrayList<Brand>)brands;
    }

    public Brand getById(int id) {
        Session session = factory.openSession();
        Brand brand=null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            brand =  session.load(Brand.class,id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return brand;
    }

    public void add(Brand brand) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer brandID = null;
        try{
            tx = session.beginTransaction();
            Brand brnd = new Brand(brand.getBrandName(),brand.getDescription());
            brnd.setBrandName(brand.getBrandName());
            brnd.setDescription(brand.getDescription());
            brandID = (Integer) session.save(brnd);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(int id, Brand brand) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Brand brnd =
                    (Brand)session.get(Brand.class, id);
            brnd.setBrandName( brand.getBrandName() );
            brnd.setDescription(brand.getDescription() );
            session.update(brnd);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public void delete(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Brand brand =
                    (Brand)session.get(Brand.class, id);
            session.delete(brand);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}