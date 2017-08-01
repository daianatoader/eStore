package model.dataaccess;

import model.entities.Admin;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import static main.MainClass.factory;

/**
 * DAO class for Admin entity that implements IAdminDAO which defines CRUD operations
 */
public class AdminDAO implements IAdminDAO{


    public AdminDAO(){}


    /**
     * method that selects all infromation from admin table
     *
     * @return ArrayList<Admin>
     */
    public List<Admin> getAll() {

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
        return admins;
    }

     /*
    public Admin getById(int id) {
        return null;
    }
    */


    /**
     * method that returns a Admin based on ID
     *
     * @param id
     * @return Admin
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


    /**
     * method that adds a new Admin object in DB
     * @param admin
     */
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

    /**
     * merthod that updates data based on ID
     * @param admin
     */
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

    /**
     * method that deletes a admin from DB based on ID
     * @param admin
     */
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

