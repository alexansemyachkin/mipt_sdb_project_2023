package ru.mipt.rea.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.rea.models.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer>{

    public Role findRoleByName(String name);

}