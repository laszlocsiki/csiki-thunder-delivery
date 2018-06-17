package dao;

import model.BaseEntity;

import java.util.List;

public interface DAO<T extends BaseEntity> {
    List<T> findAll();

    T findById(long id);

    void create(T t);
}
