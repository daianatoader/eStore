import model.dataaccess.ClientDAO;
import model.dataaccess.IClientDAO;
import model.entities.Client;
import org.junit.*;


import static main.MainClass.getConfig;
import static org.junit.Assert.*;


public class ClientDAOTest {


    @Test
    public void crudTest() {
        getConfig();
        IClientDAO cdao = new ClientDAO();

        //----------------------ADD_TEST------------------------------
        Client c = new Client("CaraianIoana", "info", "Caraian", "Ioana", "caraian.ioana@yahoo.com", 736627543L, "Str.Gradinarilor", 6578);
        cdao.add(c);
        //---------------------SELECT-TEST--------------------------
        Client reloadedClient = cdao.getById(c.getId());
        assertNotNull(reloadedClient);
        //---------------------UPDATE-TEST--------------------------
        reloadedClient.setParola("info300");
        cdao.update(reloadedClient);
        assertTrue(cdao.getById(reloadedClient.getId()).getParola().equals("info300"));
        //---------------------DELETE-TEST--------------------------
        cdao.delete(reloadedClient);
        assertFalse(cdao.getAll().toString().contains("Caraian"));
    }
}
