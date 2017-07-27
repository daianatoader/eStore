package main;

import com.fasterxml.classmate.AnnotationConfiguration;
import model.dataaccess.BrandDAO;
import model.dataaccess.IBrandDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.entities.*;

public class MainClass {
    public static SessionFactory factory;
    public static void main(String[] args){

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

        IBrandDAO bdao = new BrandDAO();
        Brand brand = new Brand("Samsung","electronice");
        bdao.add(brand);
    }
}
