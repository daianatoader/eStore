package model.dataaccess;

import model.entities.Admin;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import static main.MainClass.factory;


public class AdminDAO implements IAdminDAO{


    public AdminDAO(){}

    public static void getConfig() {
        try {
            factory = new Configuration().
                    configure().
                    addPackage("model.entities"). //add package if used.
                    addAnnotatedClass(Admin.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public ArrayList<Admin> getAll() {

        Session session = factory.openSession();
        List admins=null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            admins = session.createQuery("from model.entities.Admin").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return (ArrayList<Admin>)admins;
    }

     /*
    public Admin getById(int id) {
        return null;
    }
    */

    public Admin getById(int id) {

        Session session = factory.openSession();
        Admin admin=null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            admin =  session.load(Admin.class,id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return admin;
    }


    public void add(Admin admin) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer adminID = null;
        try{
            tx = session.beginTransaction();
            Admin adm = new Admin(admin.getUsername(),admin.getPAROLA());
            adm.setUsername(admin.getUsername());
            adm.setPAROLA(admin.getPAROLA());
            adminID = (Integer) session.save(adm);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(Admin admin) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(admin);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }


    public void delete(Admin admin) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(admin);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    }

