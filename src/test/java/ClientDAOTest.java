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
        boolean tr = false;
        for (Client client : cdao.getAll()) {
            if (client.getFirst_name().equals("Caraian")) {
                tr = true;
            }
        }
        assertTrue(tr);

        //---------------------UPDATE-TEST--------------------------

        for (Client client : cdao.getAll()) {
            if (client.getFirst_name().equals("Caraian")) {
                client.setParola("info300");
                cdao.update(client);
                assertTrue(cdao.getById(client.getId()).getParola().equals("info300"));
            }
        }

        //---------------------DELETE-TEST--------------------------

        for (Client client : cdao.getAll()) {
            if (client.getFirst_name().equals("Caraian")) {
                cdao.delete(client);
            }
        }

        //---------------------SELECT-TEST--------------------------
        assertFalse(cdao.getAll().toString().contains("Caraian"));
    }
}
