package model;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = Product.QUERY_FIND_ALL_BY_CATEGORYNAME, query = "from Product p where p.category = :categoryName"),
        @NamedQuery(name = Product.QUERY_FIND_ALL_BY_ALOHOLFREE, query = "from Product p where p.alcoholFree = :alcoholFree")
})
public class Product extends BaseEntity {
    public static final String QUERY_FIND_ALL_BY_CATEGORYNAME = "Product.findAllByCategory";
    public static final String QUERY_FIND_ALL_BY_ALOHOLFREE = "Product.findAllByAlcoholFree";

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private boolean alcoholFree;

    public Product() {
    }

    public Product(String name, String category, double price, String code, boolean alcoholFree) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.code = code;
        this.alcoholFree = alcoholFree;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isAlcoholFree() {
        return alcoholFree;
    }

    public void setAlcoholFree(boolean alcoholFree) {
        this.alcoholFree = alcoholFree;
    }
}
