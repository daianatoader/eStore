
import model.dataaccess.OrderDAO;
import model.dataaccess.IOrderDAO;
import model.entities.Order;
import model.entities.OrderStatus;
import model.entities.PaymentMethod;
import model.entities.ShippingMethod;
import org.junit.*;


import static main.MainClass.getConfig;
import static org.junit.Assert.*;

public class OrderDAOTest {

    @Test
    public void crudTest() {
        getConfig();
        IOrderDAO odao = new OrderDAO();

        //----------------------ADD_TEST------------------------------
        Order o = new Order(117F, PaymentMethod.CASH, ShippingMethod.FAST, OrderStatus.WAITING);
        odao.add(o);

        //---------------------SELECT-TEST--------------------------
        Order reloadedOrder = odao.getById(o.getId());
        assertNotNull(reloadedOrder);

        //---------------------UPDATE-TEST--------------------------
        reloadedOrder.setShippingMethod(ShippingMethod.NORMAL);
        odao.update(reloadedOrder);
        assertTrue(odao.getById(reloadedOrder.getId()).getShippingMethod().equals(ShippingMethod.NORMAL));

        //---------------------DELETE TEST-------------------------

        odao.delete(reloadedOrder);
        assertFalse(odao.getAll().toString().contains("ShippingMethod.NORMAL"));
    }
}
