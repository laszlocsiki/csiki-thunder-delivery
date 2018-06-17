package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {

    @Column(nullable = false)
    private long orderId;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private boolean payed;

    public Payment(long orderId, double price, boolean payed) {
        this.orderId = orderId;
        this.price = price;
        this.payed = payed;
    }

    public Payment() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
