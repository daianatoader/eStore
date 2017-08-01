
package main;

import model.dataaccess.*;
import model.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
    public static SessionFactory factory;

    public static void getConfig() {
        try {
            factory = new Configuration().
                    configure().
                    addPackage("model.entities"). //add package if used.
                    addAnnotatedClass(Order.class).
                    addAnnotatedClass(Client.class).
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {

        /*
        Verification for Client
         */

        //getConfig();
        //IClientDAO cdao = new ClientDAO();
        //Client client = new Client("vladrotar", "1476BCJ", "Vlad", "Rotar", "vladrotar@yahoo.com", 765438705L, "Str.Fabricii", 0236);
        //Client client2 = new Client("iulialung", "Iulia93", "Iulia", "Lung", "iulialung@yahoo.com", 794382916L, "Str.Berii", 7867);
        //Client client = new Client( "stefi", "35632", "Stefania", "Vlg", "stefaniavlg@yahoo.com", 753925668, "Str.Busteni", 87665);
        //cdao.add(client);
        //cdao.add(client2)
        //cdao.update(1, client);
        //cdao.delete(cdao.getById(4));
        //cdao.getAll();
        //for (Client c : cdao.getAll())
        //System.out.println(c.getUsername() + " " + c.getParola() + " " + c.getFirst_name() + " " + c.getLast_name() + " " + c.getEmail() + " " + c.getPhone() + " " + c.getAdress() + " " + c.getCard_number());
        //System.out.println(cdao.getById(6).getUsername());

        /*
        Verification for Client and Order (one to many relationship)
         */

        /*
        getConfig();
        IClientDAO cdao = new ClientDAO();
        Client client = cdao.getAll().get(0);
        IOrderDAO odao = new OrderDAO();
        Order order = new Order(35F, PaymentMethod.CARD, ShippingMethod.FAST, OrderStatus.WAITING);
        order.setClient(client);
        System.out.println("Before ADD");
        odao.add(order);
        System.out.println("Finished adding");
        */

        /*
        Verification for Order and Product (many to many relationship)
         */

        /*
        getConfig();
        IOrderDAO oDAO = new OrderDAO();
        IBrandDAO bdao = new BrandDAO();
        ISectionDAO sdao = new SectionDAO();
        IProductDAO pdao = new ProductDAO();

        Order o = new Order(786F, PaymentMethod.CARD, ShippingMethod.FAST, OrderStatus.WAITING);
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
        o.setProducts(product);
        o.setProducts(product2);
        oDAO.add(o);
        */
    }
}

