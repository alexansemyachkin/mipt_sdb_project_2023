package service;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.mipt.rea.dto.UserDTO;
import ru.mipt.rea.models.user.AppUser;



public interface UserService {

    AppUser save(UserDTO userDTO);

    AppUser update(UserDTO userDTO);

    AppUser registrate(UserDTO userDTO);

    AppUser findByEmail(String email);


}
