package dao;

import model.User;

import javax.ejb.Local;

@Local
public interface UserDAO extends DAO<User> {
    User findByUsername(String username);
}
