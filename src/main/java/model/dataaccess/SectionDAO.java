package model.dataaccess;

import model.entities.Product;
import model.entities.Section;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static main.MainClass.factory;

/**
 * DAO class for Section entity that implements ISectionDAO which defines CRUD operations
 */
public class SectionDAO implements ISectionDAO {

    public SectionDAO() {
    }


    /**
     * method that return a list of Section objects with data from DB
     *
     * @return List<Section>
     */
    public List<Section> getAll() {
        Session session = factory.openSession();
        List sections = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            sections = session.createQuery("from model.entities.Section").list();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return sections;
    }

    /**
     * method that returns an abject of type Section with data from DB
     *
     * @param id
     * @return Section
     */
    public Section getById(int id) {
        Section section = null;
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                section = session.load(Section.class, id);
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return section;
    }

    /**
     * Method that returns a Section by name
     *
     * @param name
     * @return
     */
    @Override
    public Section getByName(String name) {
        Section section = null;
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            Criteria cr = null;
            try {
                tx = session.beginTransaction();
                cr = session.createCriteria(Section.class);
                cr.add(Restrictions.eq("sectionName", name));
                section = (Section) cr.uniqueResult();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return section;
    }

    /**
     * method that adds data in DB
     *
     * @param section
     */
    public void add(Section section) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(section);
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
     * @param section
     */
    public void update(Section section) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.update(section);
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
     * method that deletes a field form section table from DB
     *
     * @param section
     */
    public void delete(Section section) {
        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.delete(section);
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
