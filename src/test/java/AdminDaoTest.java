import model.dataaccess.AdminDAO;
import model.dataaccess.IAdminDAO;
import model.entities.Admin;
import org.junit.*;

import static model.dataaccess.AdminDAO.getConfig;
import static org.junit.Assert.*;

public class AdminDaoTest {


    @Test
    public void crudTest() {

        getConfig();
        IAdminDAO adao = new AdminDAO();


        //--------------------ADD_TEST------------------
        Admin a = new Admin("deni", "1234");
        adao.add(a);
        boolean tr = false;
        for (Admin admin : adao.getAll()) {
            if (admin.getUsername().equals("deni")) {
                tr = true;
            }
        }
        assertTrue(tr);


        //-------------UPDATE-TEST-----------------------
        Admin a1 = new Admin("deni", "2344");
        for (Admin admin : adao.getAll()) {
            if (admin.getUsername().equals("deni")) {
                adao.update(adao.getById(admin.getID()));
                assertTrue(adao.getById(admin.getID()).getUsername().equals("deni"));
            }
        }


        //-------------DELETE-TEST-----------------------

        for (Admin admin : adao.getAll()) {
            if (admin.getUsername().equals("deni")) {
                adao.delete(adao.getById(admin.getID()));
            }
        }

        //-------------SELECT-TEST-----------------------
        assertFalse(adao.getAll().toString().contains("deni"));
    }

}
