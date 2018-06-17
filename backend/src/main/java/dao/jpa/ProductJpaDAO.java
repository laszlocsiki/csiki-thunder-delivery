package dao.jpa;

import dao.DAOException;
import dao.ProductDAO;
import model.Product;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProductJpaDAO extends JpaDAO<Product> implements ProductDAO {
    public ProductJpaDAO() {
        super(Product.class);
    }

    @Override
    public List<Product> findAllByCategory(String categoryName) {
        TypedQuery<Product> query = em.createNamedQuery(Product.QUERY_FIND_ALL_BY_CATEGORYNAME, Product.class);
        query.setParameter("categoryName", categoryName);

        try {
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new DAOException("Connection closed!", ex);
        }
    }

    @Override
    public List<Product> findAllByAlcoholFree(boolean alcoholFree) {
        TypedQuery<Product> query = em.createNamedQuery(Product.QUERY_FIND_ALL_BY_ALOHOLFREE, Product.class);
        query.setParameter("alcoholFree", alcoholFree);

        try {
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new DAOException("Connection closed!", ex);
        }
    }
}
