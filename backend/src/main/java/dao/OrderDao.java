package dao;

import model.Order;

import javax.ejb.Local;

@Local
public interface OrderDao extends DAO<Order> {
}
