package model.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")

public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "price")
    private float price;

    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;


    @Column(name = "shipping_method")
    @Enumerated(EnumType.STRING)
    private ShippingMethod shippingMethod;


    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "order_products", joinColumns = {
            @JoinColumn(name = "order_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id",
                    nullable = false)})
    private Set<Product> products;

    public Order(float price, PaymentMethod paymentMethod, ShippingMethod shippingMethod, OrderStatus orderStatus) {
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.orderStatus = orderStatus;
        this.products = new HashSet<Product>(0);
    }

    public Order() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }
}
