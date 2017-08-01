package model.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "details")
    private String details;

    @Column(name = "price")
    private float price;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Section.class)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Brand.class)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<Campaign> campaigns;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<Order> orders;

    public Product() {
    }

    public Product(String productName, String details, float price, Section section, Brand brand) {
        this.productName = productName;
        this.details = details;
        this.price = price;
        this.section = section;
        this.brand = brand;
        this.campaigns = new HashSet<Campaign>(0);
        this.orders = new HashSet<Order>(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Campaign> getCampaigns() {
        return this.campaigns;
    }

    public void setCampaigns(Campaign campaign) {
        this.campaigns.add(campaign);
    }

    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Order order) {
        this.orders.add(order);
    }
}
