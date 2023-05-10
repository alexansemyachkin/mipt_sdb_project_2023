package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    public User findByEmail(String email);
    public User findById(int id);

}
