
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
                    addAnnotatedClass(Admin.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static void main(String[] args) {
        getConfig();
        ICampaignDAO campDao = new CampaignDAO();
        IBrandDAO bdao = new BrandDAO();
        ISectionDAO sdao = new SectionDAO();
        IProductDAO pdao = new ProductDAO();

        Campaign a = new Campaign("reducereTel", "1234", 6);
        Section section = new Section("Electronics");
        Brand brand = new Brand("LG", "telefoane");
        bdao.add(brand);
        sdao.add(section);
        Brand brandTmp = bdao.getByName("LG");
        Section sectionTmp = sdao.getByName("Electronics");
        Product product = new Product("Telefon", "smartphone", 800, sectionTmp, brandTmp);
        Product product2 = new Product("MP3", "fs", 200, sectionTmp, brandTmp);
        pdao.add(product);
        pdao.add(product2);
        a.setProducts(product);
        a.setProducts(product2);
        campDao.add(a);
    }
}
