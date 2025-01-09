package ma.enset.exam_mohammed_elbadry.dao;

import java.util.List;

public interface Dao<T>{
    List<T> findAll();
    T findById(int id);
    void save(T o);
    void update(T o);
    void delete(int id);
}