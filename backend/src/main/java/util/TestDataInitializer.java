package util;

import dao.OrderDao;
import dao.ProductDAO;
import dao.UserDAO;
import model.Order;
import model.Product;
import model.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Date;

@Singleton
@Startup
public class TestDataInitializer {
    @EJB
    private ProductDAO productDAO;
    @EJB
    private UserDAO userDAO;
    @EJB
    private OrderDao orderDao;

    @EJB
    private PasswordEncrypter passwordEncrypter;

    @PostConstruct
    public void initialize() {
        userDAO.create(new User("delivery1", passwordEncrypter.createHash("test"), "Csiki Laszlo"));
        userDAO.create(new User("delivery2", passwordEncrypter.createHash("test"), "Csiki Nandor"));
        userDAO.create(new User("delivery3", passwordEncrypter.createHash("test"), "Csiki Szilard"));

        productDAO.create(new Product("Tiltott Csiki sor", "tiltott", 12, "123RERECASDQ", false));
        productDAO.create(new Product("Igazi Csiki sor", "tiltott", 4, "ZZZZADQE214", false));
        productDAO.create(new Product("Mezes Csiki sor", "kompotle", 5, "XZCGHHE2223432", false));
        productDAO.create(new Product("Afonyas Csiki sor", "kompotle", 8, "VADSA4431DAD", false));
        productDAO.create(new Product("Hamis Csiki sor", "alkoholmentes", 3, "3123DASDWQEQ", true));

        orderDao.create(new Order("Ciumani", 1, 1, new Date()));
        orderDao.create(new Order("Joseni", 3, 3, new Date()));
        orderDao.create(new Order("Gheorgheni", 4, 2, new Date()));
    }
}
