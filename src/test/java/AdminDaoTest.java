import model.dataaccess.AdminDAO;
import model.dataaccess.IAdminDAO;
import model.entities.Admin;
import org.junit.Test;

import static main.MainClass.getConfig;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminDaoTest {


    @Test
    public void crudTest() {

        getConfig();
        IAdminDAO adao = new AdminDAO();

        //--------------------ADD_TEST------------------
        Admin a = new Admin("deni", "1234");
        adao.add(a);

        //-------------SELECT-TEST-----------------------
        Admin admin = adao.getById(a.getID());


        //-------------UPDATE-TEST-----------------------
        admin.setPAROLA("12345");
        adao.update(admin);

        Admin reloadedAdmin = adao.getById(a.getID());
        assertTrue(reloadedAdmin.getPAROLA().equals("12345"));

        //-------------DELETE-TEST-----------------------
        adao.delete(admin);
        assertFalse(adao.getAll().toString().contains("deni"));
    }

}




