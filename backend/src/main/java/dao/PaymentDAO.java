package dao;

import model.Payment;

import javax.ejb.Local;

@Local
public interface PaymentDAO extends DAO<Payment> {
}
