package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import ru.mipt.rea.models.User;

public interface UserRepo extends CrudRepository<User, Integer> {

    public User findByEmail(String email);
    public User findById(int id);

}
