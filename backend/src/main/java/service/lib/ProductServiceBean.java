package service.lib;

import dao.DAOException;
import dao.ProductDAO;
import model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ProductService;
import service.ServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProductServiceBean implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceBean.class);

    @EJB
    private ProductDAO productDAO;

    @Override
    public List<Product> findAllProduct() throws ServiceException {
        try {
            return productDAO.findAll();
        } catch (DAOException e) {
            LOG.error("findAllProduct failed");
            throw new ServiceException("findAllProduct failed", e);
        }
    }

    @Override
    public List<Product> findAllProductOfCategory(String categoryName) throws ServiceException {
        try {
            return productDAO.findAllByCategory(categoryName);
        } catch(DAOException ex) {
            LOG.error("Find all product by category failed!");
            throw new ServiceException("Find all product by category failed!", ex);
        }
    }

    @Override
    public void createProduct(Product product) throws ServiceException {
        try {
            productDAO.create(product);
        } catch (DAOException e) {
            LOG.error("createProduct failed");
            throw new ServiceException("findAllProduct failed", e);
        }
    }

    @Override
    public Product findById(long id) throws ServiceException {
        try {
            return productDAO.findById(id);
        } catch (DAOException e) {
            LOG.error("findById failed");
            throw new ServiceException("findById failed", e);
        }
    }
}
