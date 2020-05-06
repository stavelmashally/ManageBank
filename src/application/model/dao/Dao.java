package application.model.dao;

import java.util.List;

public interface Dao<T> {

    T findById(int id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
