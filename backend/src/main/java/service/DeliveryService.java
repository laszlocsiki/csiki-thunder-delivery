package service;

import model.Delivery;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DeliveryService {
    List<Delivery> findAllDelivery();

    void createDelivery(Delivery delivery);

    Delivery findById(long id);
}
