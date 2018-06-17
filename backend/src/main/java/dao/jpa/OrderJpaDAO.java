package dao.jpa;

import dao.OrderDao;
import model.Order;

import javax.ejb.Stateless;

@Stateless
public class OrderJpaDAO extends JpaDAO<Order> implements OrderDao {

    public OrderJpaDAO() {
        super(Order.class);
    }
}
