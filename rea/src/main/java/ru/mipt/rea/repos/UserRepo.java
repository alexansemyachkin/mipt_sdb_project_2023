package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    User findByEmail(String email);

    User findById(int id);

}
