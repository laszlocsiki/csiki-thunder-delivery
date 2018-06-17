package service;

import model.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductService {
    List<Product> findAllProduct();

    List<Product> findAllProductOfCategory(String categoryName);

    void createProduct(Product product);

    Product findById(long id);
}
