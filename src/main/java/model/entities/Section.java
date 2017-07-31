package model.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "section_name")
    private String sectionName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "section")
    private Set<Product> products;

    public Section() {
    }

    public Section(String sectionName) {
        this.sectionName = sectionName;
        this.products = new HashSet<Product>(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }

}