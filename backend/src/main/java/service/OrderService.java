package service;

import model.Order;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrderService {
    List<Order> findAllOrder();

    Order findById(long id);

    void createOrder(Order order);
}
