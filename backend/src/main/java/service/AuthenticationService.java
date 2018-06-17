package service;

import model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AuthenticationService {
    void register(User newUser) throws ServiceException;

    boolean validatePassword(String username, String password) throws ServiceException;

    List<User> findAllUsers() throws ServiceException;

    User findByUsername(String username) throws ServiceException;
}
