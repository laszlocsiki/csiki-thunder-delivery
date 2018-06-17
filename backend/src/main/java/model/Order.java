package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private long productId;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private Date orderDate;

    public Order() {
    }

    public Order(String address, long productId, int amount, Date orderDate) {
        this.address = address;
        this.productId = productId;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
