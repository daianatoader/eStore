import model.dataaccess.BrandDAO;
import model.dataaccess.IBrandDAO;
import model.entities.Brand;
import org.junit.*;


import static model.dataaccess.BrandDAO.getConfig;
import static org.junit.Assert.*;


public class BrandDAOTest {


    @Test
    public void crudTest() {
        getConfig();
        IBrandDAO bdao = new BrandDAO();

        //----------------------ADD_TEST------------------------------
        Brand b = new Brand("Motorola", "telefoane");
        bdao.add(b);
        boolean tr = false;
        for (Brand brand : bdao.getAll()) {
            if (brand.getBrandName().equals("Motorola")) {
                tr = true;
            }
        }
        assertTrue(tr);

        //---------------------UPDATE-TEST--------------------------
        for (Brand brand : bdao.getAll()) {
            if (brand.getBrandName().equals("Motorola")) {
                brand.setDescription("electronice");
                bdao.update(brand);
                assertTrue(bdao.getById(brand.getId()).getDescription().equals("electronice"));
            }
        }

        //---------------------DELETE-TEST--------------------------
        for (Brand brand : bdao.getAll()) {
            if (brand.getBrandName().equals("Motorola")) {
                bdao.delete(brand);
            }
        }

        //---------------------SELECT-TEST--------------------------
        assertFalse(bdao.getAll().toString().contains("Motorola"));
    }


}
