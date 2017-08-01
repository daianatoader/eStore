import model.dataaccess.*;
import model.entities.Brand;
import model.entities.Product;
import model.entities.Section;
import org.junit.*;


import static main.MainClass.getConfig;
import static org.junit.Assert.*;


public class ProductDAOTest {


    @Test
    public void crudTest() {
        getConfig();
        IProductDAO pdao = new ProductDAO();
        IBrandDAO bdao = new BrandDAO();
        ISectionDAO sdao = new SectionDAO();

        //----------------------ADD_TEST------------------------------

        Section section = new Section("Electronics");
        Brand brand = new Brand("LG", "telefoane");
        bdao.add(brand);
        sdao.add(section);
        Brand brandTmp = bdao.getByName("LG");
        Section sectionTmp = sdao.getByName("Electronics");
        Product product = new Product("Telefon", "smartphone", 800, sectionTmp, brandTmp);
        pdao.add(product);
        boolean tr = false;
        for (Product productTmp : pdao.getAll()) {
            if (productTmp.getProductName().equals("Telefon") &&
                    productTmp.getDetails().equals("smartphone") &&
                    productTmp.getPrice() == 800 &&
                    productTmp.getSection().getSectionName().equals("Electronics") &&
                    productTmp.getBrand().getBrandName().equals("LG")) {
                tr = true;
            }
        }
        assertTrue(tr);

        //---------------------UPDATE-TEST--------------------------

        product.setProductName("Smartphone");
        pdao.update(product);
        Product productReloadedFromBD = pdao.getById(product.getId());
        assertTrue(productReloadedFromBD.getProductName().equals("Smartphone"));

        //---------------------DELETE-TEST--------------------------

        pdao.delete(product);
        bdao.delete(brandTmp);
        sdao.delete(sectionTmp);

        //---------------------SELECT-TEST--------------------------
        assertFalse(pdao.getAll().toString().contains("Smartphone"));
    }


}
