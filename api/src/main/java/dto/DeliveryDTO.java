package dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDTO extends AbstractDTO {
    private long id;
    private long orderId;
    private long userid;
    private String status;
    private Date deliveryDate;
    private long paymentId;


    public DeliveryDTO() {
    }

    public DeliveryDTO(long id, long orderId, long userid, String status, Date deliveryDate, long paymentId) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
