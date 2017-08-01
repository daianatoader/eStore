import model.dataaccess.*;
import model.entities.Brand;
import model.entities.Campaign;
import model.entities.Product;
import model.entities.Section;
import org.junit.Test;

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
        boolean tr = false;

        //-------------SELECT-TEST-----------------------
        Campaign campaign = campDao.getById(a.getId());
        assertNotNull(campaign);


        //-------------UPDATE-TEST-----------------------
        campaign.setDetails("Reducere Telefon");
        campDao.update(campaign);

        Campaign reloadedCampaign = campDao.getById(a.getId());
        assertTrue(reloadedCampaign.getDetails().equals("Reducere Telefon"));


        //-------------DELETE-TEST-----------------------
        campDao.delete(campaign);
        assertFalse(campDao.getAll().toString().contains("Reducere Telefon"));
    }

}
