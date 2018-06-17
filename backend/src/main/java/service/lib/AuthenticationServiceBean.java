package service.lib;

import dao.DAOException;
import dao.UserDAO;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.AuthenticationService;
import service.ServiceException;
import util.PasswordEncrypter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AuthenticationServiceBean implements AuthenticationService {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationServiceBean.class);

    @EJB
    private UserDAO userDao;

    @EJB
    private PasswordEncrypter passwordEncrypter;

    @Override
    public void register(User newUser) throws ServiceException {
        String encryptedPassword = passwordEncrypter.createHash(newUser.getPassword());
        newUser.setPassword(encryptedPassword);

        try {
            userDao.create(newUser);
        } catch (DAOException ex) {
            LOG.error("Already existing username!");
            throw new ServiceException("Already existing username!", ex);
        }
    }

    @Override
    public boolean validatePassword(String username, String password) throws ServiceException {
        User user;

        try {
            user = userDao.findByUsername(username);
        } catch (DAOException ex) {
            LOG.error("Find by username failed!");
            throw new ServiceException("Find by username failed!", ex);
        }

        if (user == null) {
            LOG.error("Username or password already exists!");
            return false;
        }

        return passwordEncrypter.validatePassword(password, user.getPassword());
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        try {
            return userDao.findAll();
        } catch (DAOException ex) {
            LOG.error("Find all user failed!");
            throw new ServiceException("Find all user failed!", ex);
        }
    }

    @Override
    public User findByUsername(String username) throws ServiceException {
        try {
            return userDao.findByUsername(username);
        } catch (DAOException ex) {
            LOG.error("Find by username failed!");
            throw new ServiceException("Find by username failed!", ex);
        }
    }

}
