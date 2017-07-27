package model.dataaccess;

import model.entities.Admin;
import org.hibernate.Session;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.*;




public class AdminDAO implements IAdminDAO{
    private static SessionFactory factory;

    public AdminDAO(){}

    public ArrayList<Admin> getAll() {
        return null;
    }

    public Admin getById(int id) {
        return null;
    }

    public void add(Admin admin) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Admin adm = new Admin();
            //employee.setFirstName(fname);
           // employee.setLastName(lname);
           // employee.setSalary(salary);
           // employeeID = (Integer) session.save(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void update(int id, Admin admin) {

    }

    public void delete(int id) {

    }
}
