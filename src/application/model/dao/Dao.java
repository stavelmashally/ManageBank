package application.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T findByEmail(String email);

    T findById(int id);

    List<T> findAll();

    boolean save(T t);

    boolean update(T t);

    boolean delete(int id);
}
