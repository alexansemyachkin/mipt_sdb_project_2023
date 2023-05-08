package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import ru.mipt.rea.models.user.User;

public interface UserRepo extends CrudRepository<User, Integer> {

    public User findByEmail(String email);

}
