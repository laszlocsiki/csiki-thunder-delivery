package service;

import model.Payment;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PaymentService {
    List<Payment> findAllPayment();

    Payment findById(long id);

    void createPayment(Payment payment);
}
