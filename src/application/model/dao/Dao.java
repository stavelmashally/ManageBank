package application.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T findByEmail(String email);

    T findById(int id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
