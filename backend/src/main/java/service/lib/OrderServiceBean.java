package service.lib;

import dao.DAOException;
import dao.OrderDao;
import model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.OrderService;
import service.ServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderServiceBean implements OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceBean.class);

    @EJB
    private OrderDao orderDao;

    @Override
    public List<Order> findAllOrder() throws ServiceException {
        try {
            return orderDao.findAll();
        } catch (DAOException ex) {
            LOG.error("Find all order failed!");
            throw new ServiceException("Find all order failed!", ex);
        }
    }

    @Override
    public Order findById(long id) {
        try {
            return orderDao.findById(id);
        } catch (DAOException ex) {
            LOG.error("Find all order failed!");
            throw new ServiceException("Find all order failed!", ex);
        }
    }


    @Override
    public void createOrder(Order order) throws ServiceException {
        try {
            orderDao.create(order);
        } catch (DAOException e) {
            LOG.error("Create order failed");
            throw new ServiceException("Create order failed", e);
        }
    }
}
