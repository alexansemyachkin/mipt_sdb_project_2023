package ru.mipt.rea.service;


public interface UserService<T, V> {

    T save(V dto);
    T update(V dto);
    T registrate(V dto);
    T findByEmail(String email);

}
