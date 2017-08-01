package model.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name="campaign")


public class Campaign {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "details")
    private String details;

    @Column(name = "period")
    private String period;

    @Column (name = "discount")
    private int discount;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_campaign", joinColumns = {
            @JoinColumn(name = "campaign_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id",
                    nullable = false)})
    private Set<Product> products;

    public Campaign() { }

    public Campaign(String details, String period, int discount) {
        this.details = details;
        this.period = period;
        this.discount = discount;
        this.products = new HashSet<Product>(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }
}

