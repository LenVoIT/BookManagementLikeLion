package BookManagement.Spring.Service;

import java.util.Collection;
import java.util.Iterator;

public interface BaseService<T> {
    T create(T t);
    T save(T t);
    void remove(int id);
    Iterable<T> findAll();
    T findById(int id);
}
