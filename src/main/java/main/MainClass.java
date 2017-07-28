
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

import static model.dataaccess.BrandDAO.getConfig;

public class MainClass {
    public static SessionFactory factory;

    public static void main(String[] args) {


        getConfig();

        IBrandDAO bdao = new BrandDAO();
        Brand brand = new Brand("Philips", "electronice");
        Brand brand2 = new Brand("Colgate", "igiena");
        bdao.delete(3);

        //bdao.add(brand);
        // bdao.add(brand2);

        for (Brand b : bdao.getAll())
            System.out.println(b.getBrandName() + " " + b.getDescription());

        System.out.println(bdao.getById(1).getBrandName());
    }
}
