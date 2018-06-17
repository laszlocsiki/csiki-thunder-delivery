package dao.jpa;

import dao.DeliveryDAO;
import model.Delivery;

import javax.ejb.Stateless;

@Stateless
public class DeliveryJpaDAO extends JpaDAO<Delivery> implements DeliveryDAO {

    public DeliveryJpaDAO() {
        super(Delivery.class);
    }
}
