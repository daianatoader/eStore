package model.dataaccess;

import model.entities.Campaign;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import static main.MainClass.factory;

public class CampaignDAO implements ICampaignDAO {

    public CampaignDAO(){}

    public static void getConfig() {
        try {
            factory = new Configuration().
                    configure().
                    addPackage("model.entities"). //add package if used.
                    addAnnotatedClass(Campaign.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public ArrayList<Campaign> getAll() {

        Session session = factory.openSession();
        List campaigns=null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            campaigns = session.createQuery("from model.entities.Campaign").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return (ArrayList<Campaign>)campaigns;
    }

   public Campaign getById(int id) {

        Session session = factory.openSession();
        Campaign campaign=null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            campaign =  session.load(Campaign.class,id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return campaign;
    }

    public void add(Campaign campaign) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(campaign);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(Campaign campaign) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(campaign);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    public void delete(Campaign campaign) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(campaign);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
