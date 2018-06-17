package dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO extends AbstractDTO {
    private long id;
    private String address;
    private long productId;
    private int amount;
    private Date orderDate;


    public OrderDTO() {
    }

    public OrderDTO(long id, String address, long productId, int amount, Date orderDate) {
        this.id = id;
        this.address = address;
        this.productId = productId;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
