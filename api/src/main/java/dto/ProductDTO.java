package dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO extends AbstractDTO {
    private long id;
    private String name;
    private String category;
    private double price;
    private String code;
    private boolean alcoholFree;

    public ProductDTO() {
    }

    public ProductDTO(long id, String name, String category, double price, String code, boolean alcoholFree) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.code = code;
        this.alcoholFree = alcoholFree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
