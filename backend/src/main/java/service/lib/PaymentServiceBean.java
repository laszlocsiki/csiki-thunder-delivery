package service.lib;

import dao.DAOException;
import dao.PaymentDAO;
import model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.PaymentService;
import service.ServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PaymentServiceBean implements PaymentService {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceBean.class);

    @EJB
    private PaymentDAO paymentDAO;

    @Override
    public List<Payment> findAllPayment() {
        try {
            return paymentDAO.findAll();
        } catch (DAOException ex) {
            LOG.error("Find all payment failed!");
            throw new ServiceException("Find all payment failed!", ex);
        }
    }

    @Override
    public Payment findById(long id) {
        try {
            return paymentDAO.findById(id);
        } catch (DAOException ex) {
            LOG.error("Find payment failed!");
            throw new ServiceException("Find payment failed!", ex);
        }
    }

    @Override
    public void createPayment(Payment payment) throws ServiceException {
        try {
            paymentDAO.create(payment);
        } catch (DAOException e) {
            LOG.error("Create payment failed");
            throw new ServiceException("Create payment failed", e);
        }
    }
}
