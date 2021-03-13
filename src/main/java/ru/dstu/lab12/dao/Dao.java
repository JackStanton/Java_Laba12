package ru.dstu.lab12.dao;

import java.util.List;


public interface Dao<T> {

    public List<T> findAll();

    public T findById(Long id);

    public void save(T obj);

    public void deleteById(Long id);
}
