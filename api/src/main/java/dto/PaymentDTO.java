package dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDTO extends AbstractDTO {
    private long id;
    private long orderId;
    private double price;
    private boolean payed;

    public PaymentDTO() {
    }

    public PaymentDTO(long id, long orderId, double price, boolean payed) {
        this.id = id;
        this.orderId = orderId;
        this.price = price;
        this.payed = payed;
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

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
