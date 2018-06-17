package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "delivery")
public class Delivery extends BaseEntity {

    @Column(nullable = false, unique = true)
    private long orderId;

    @Column(nullable = false)
    private long userid;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date deliveryDate;

    @Column(nullable = false)
    private long paymentId;

    public Delivery() {
    }

    public Delivery(long orderId, long userid, String status, Date deliveryDate, long paymentId) {
        this.orderId = orderId;
        this.userid = userid;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.paymentId = paymentId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
