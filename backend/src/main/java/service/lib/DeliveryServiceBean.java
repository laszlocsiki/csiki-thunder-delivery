package service.lib;

import dao.DAOException;
import dao.DeliveryDAO;
import model.Delivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DeliveryService;
import service.ServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DeliveryServiceBean implements DeliveryService {
    private static final Logger LOG = LoggerFactory.getLogger(DeliveryServiceBean.class);

    @EJB
    private DeliveryDAO deliveryDAO;

    @Override
    public List<Delivery> findAllDelivery() throws ServiceException {
        try {
            return deliveryDAO.findAll();
        } catch (DAOException ex) {
            LOG.error("Find all deliver failed!");
            throw new ServiceException("Find all deliver failed!", ex);
        }
    }

    @Override
    public Delivery findById(long id) {
        try {
            return deliveryDAO.findById(id);
        } catch (DAOException ex) {
            LOG.error("Find all deliver failed!");
            throw new ServiceException("Find all deliver failed!", ex);
        }
    }


    @Override
    public void createDelivery(Delivery delivery) throws ServiceException {
        try {
            deliveryDAO.create(delivery);
        } catch (DAOException e) {
            LOG.error("Create deliver failed");
            throw new ServiceException("Create deliver failed", e);
        }
    }
}
