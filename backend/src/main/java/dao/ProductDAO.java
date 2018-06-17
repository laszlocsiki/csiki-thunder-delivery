package dao;

import model.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductDAO extends DAO<Product> {
    List<Product> findAllByCategory(String categoryName);

    List<Product> findAllByAlcoholFree(boolean alcoholFree);
}
