package dao.jpa;

import dao.DAOException;
import dao.UserDAO;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserJpaDAO extends JpaDAO<User> implements UserDAO {
    public UserJpaDAO() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_USERNAME_QUERY, User.class);
        query.setParameter("username", username);

        try {
            List<User> users = query.getResultList();
            if (users.isEmpty()) {
                return null;
            }
            return users.get(0);
        } catch (PersistenceException ex) {
            throw new DAOException("Connection closed!", ex);
        }
    }
}
