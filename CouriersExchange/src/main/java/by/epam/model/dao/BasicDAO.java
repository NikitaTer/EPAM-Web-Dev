package by.epam.model.dao;

import java.util.List;
import java.util.Optional;

public interface BasicDAO<K, T> {
    List<T> findAll();
    Optional<T> find(K k);

    void insert(T t);
    Optional<T> update(T t);
    void delete(K k);
}
