package model.dataaccess;

import model.entities.Campaign;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static main.MainClass.factory;

/**
 * DAO class for Campaign entity that implements ICampaignDAO which defines CRUD operations
 */
public class CampaignDAO implements ICampaignDAO {

    public CampaignDAO() {
    }


    /**
     * method that selects all information from Campaign table
     *
     * @return ArrayList<Campaign>
     */
    public List<Campaign> getAll() {

        Session session = factory.openSession();
        List campaigns = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            campaigns = session.createQuery("from model.entities.Campaign").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return campaigns;
    }

    /**
     * method that returns a Campaign based on ID
     *
     * @param id
     * @return
     */
    public Campaign getById(int id) {

        Session session = factory.openSession();
        Campaign campaign = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            campaign = session.load(Campaign.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return campaign;
    }

    /**
     * method that adds a new Campaign object in DB
     *
     * @param campaign
     */
    public void add(Campaign campaign) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(campaign);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * merthod that updates data based on ID
     *
     * @param campaign
     */
    public void update(Campaign campaign) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(campaign);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /**
     * method that deletes a campaign from DB based on ID
     * method that deletes a campaign from DB based on ID
     *
     * @param campaign
     */
    public void delete(Campaign campaign) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(campaign);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
