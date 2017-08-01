
package main;


import model.dataaccess.*;
import org.hibernate.SessionFactory;
import model.entities.*;
import org.hibernate.cfg.Configuration;



public class MainClass {
    public static SessionFactory factory;

    public static void getConfig() {
        try {
            factory = new Configuration().
                    configure().
                    addPackage("model.entities"). //add package if used.
                    addAnnotatedClass(Product.class).
                    addAnnotatedClass(Section.class).
                    addAnnotatedClass(Brand.class).
                    addAnnotatedClass(Campaign.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static void main(String[] args) {
        getConfig();

    }
}
