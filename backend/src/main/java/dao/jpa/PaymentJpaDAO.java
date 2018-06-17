package dao.jpa;

import dao.PaymentDAO;
import model.Payment;

import javax.ejb.Stateless;

@Stateless
public class PaymentJpaDAO extends JpaDAO<Payment> implements PaymentDAO {

    public PaymentJpaDAO() {
        super(Payment.class);
    }
}
