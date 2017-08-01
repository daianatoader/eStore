import model.dataaccess.*;
import model.entities.Campaign;
import org.junit.*;

import model.entities.Brand;
import model.entities.Product;
import model.entities.Section;

import static main.MainClass.getConfig;
import static org.junit.Assert.*;


public class CampaignDAOTest {


    @Test
    public void crudTest() {

        getConfig();
        ICampaignDAO campDao = new CampaignDAO();
        IBrandDAO bdao = new BrandDAO();
        ISectionDAO sdao = new SectionDAO();
        IProductDAO pdao = new ProductDAO();
        //--------------------ADD_TEST------------------
        Campaign a = new Campaign("reducereTel","1234",6);
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
        boolean tr = false;
        for (Campaign campaign : campDao.getAll()) {
           if(campaign.getDetails().equals("reducereTel"))
               tr=true;
        }
        assertTrue(tr);


        //-------------UPDATE-TEST-----------------------
        Campaign a1 = new Campaign("reducereTel", "2356",6);
        for (Campaign campaign : campDao.getAll()) {
            if(campaign.getDetails().equals("reducereTel")){
                campDao.update(campDao.getById(campaign.getId()));
                assertTrue(campDao.getById(campaign.getId()).getDetails().equals("reducereTel"));
            }
        }


        //-------------DELETE-TEST-----------------------

        for (Campaign campaign : campDao.getAll()) {
            if (campaign.getDetails().equals("reducereTel")) {
                campDao.delete(campDao.getById(campaign.getId()));
            }
        }

        //-------------SELECT-TEST-----------------------
        assertFalse(campDao.getAll().toString().contains("reducereTel"));
    }

}
