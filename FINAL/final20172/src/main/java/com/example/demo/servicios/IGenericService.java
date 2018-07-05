package com.example.demo.servicios;

import java.util.List;

public interface IGenericService<T> {
    boolean create(T t);
    List<T> list();
    boolean delete(int id);
    boolean update(T t);
}
