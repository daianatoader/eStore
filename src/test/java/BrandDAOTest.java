import model.dataaccess.BrandDAO;
import model.dataaccess.IBrandDAO;
import model.entities.Brand;
import org.junit.*;


import static main.MainClass.getConfig;
import static org.junit.Assert.*;


public class BrandDAOTest {


    @Test
    public void crudTest() {
        getConfig();
        IBrandDAO bdao = new BrandDAO();

        //----------------------ADD_TEST------------------------------
        Brand brand = new Brand("Motorola", "telefoane");
        bdao.add(brand);
        boolean tr = false;
        for (Brand b : bdao.getAll()) {
            if (b.getBrandName().equals("Motorola")) {
                tr = true;
            }
        }
        assertTrue(tr);

        //---------------------UPDATE-TEST--------------------------
        brand.setDescription("electronice");
        bdao.update(brand);
        Brand brandReloadedFromBD = bdao.getById(brand.getId());
        assertTrue(brandReloadedFromBD.getDescription().equals("electronice"));

        //---------------------DELETE-TEST--------------------------
        bdao.delete(brand);

        //---------------------SELECT-TEST--------------------------
        assertFalse(bdao.getAll().toString().contains("Motorola"));
    }


}
