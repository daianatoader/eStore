
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
        boolean tr = false;
        for (Order order : odao.getAll()) {
            if (order.getShippingMethod().equals(ShippingMethod.FAST))
                tr = true;
        }
        assertTrue(tr);

        //---------------------UPDATE-TEST--------------------------

        for (Order order : odao.getAll()) {
            if (order.getShippingMethod().equals(ShippingMethod.FAST)) {
                order.setOrderStatus(OrderStatus.DELIVERED);
                odao.update(order);
                assertTrue(odao.getById(order.getId()).getOrderStatus().equals(OrderStatus.DELIVERED));
            }
        }

        //---------------------DELETE-TEST--------------------------

        for (Order order : odao.getAll()) {
            if (order.getShippingMethod().equals(ShippingMethod.FAST)) {
                odao.delete(order);
            }
        }

        //---------------------SELECT-TEST--------------------------
        assertFalse(odao.getAll().toString().contains("ShippingMethod.FAST"));
    }
}
