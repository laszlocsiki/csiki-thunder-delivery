package dao.jpa;

import dao.DAO;
import dao.DAOException;
import model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public abstract class JpaDAO<T extends BaseEntity> implements DAO<T> {

    private static final Logger LOG = LoggerFactory.getLogger(JpaDAO.class);
    private final Class<T> entityClass;
    @PersistenceContext(unitName = "deliveryPU")
    EntityManager em;

    public JpaDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        try {
            TypedQuery<T> findAllQuery = em.createQuery("from " + entityClass.getSimpleName(), entityClass);
            return findAllQuery.getResultList();
        } catch (PersistenceException e) {
            LOG.error("find all failed", e);
            throw new DAOException("find all failed", e);
        }

    }

    @Override
    public T findById(long id) {
        try {
            return em.find(entityClass, id);

        } catch (IllegalArgumentException e) {
            LOG.error("find by id failed", e);
            throw new DAOException("find by id failed", e);

        }

    }

    @Override
    @Transactional
    public void create(T t) {
        try {
            em.persist(t);
        } catch (EntityExistsException | IllegalArgumentException e) {
            LOG.error("create failed", e);
            throw new DAOException("create failed", e);

        }
    }


}
