import model.dataaccess.CampaignDAO;
import model.dataaccess.ICampaignDAO;
import model.entities.Campaign;
import org.junit.*;

import static model.dataaccess.CampaignDAO.getConfig;
import static org.junit.Assert.*;


public class CampaignDaoTest {


    @Test
    public void crudTest() {

        getConfig();
        ICampaignDAO campDao = new CampaignDAO();


        //--------------------ADD_TEST------------------
        Campaign a = new Campaign("reducereTel","1234",6);
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
