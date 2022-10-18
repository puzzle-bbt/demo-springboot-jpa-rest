package ch.puzzle.demo.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.TODO;

import ch.puzzle.demo.exception.BusinessException;
import ch.puzzle.demo.model.User;

@Service
public class UserService {

    private final UserCrudRepository userCrudRepository;

    public UserService(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    public Iterable<User> getAllUsers() {return userCrudRepository.findAll();}

    public User getUserById(long id) throws BusinessException {
        return userCrudRepository.findById(id).orElseThrow(() -> new BusinessException(404, "User not found"));
    }

    public User saveUser(User user) {
        return userCrudRepository.save(user);
    }

    public User updateUser(long id, User newUser) throws BusinessException {
        return userCrudRepository.findById(id).map(
                user -> {
                    user.setFirstname(newUser.getFirstname());
                    user.setLastname(newUser.getLastname());
                    user.setEmail(newUser.getEmail());
                    user.setAge(newUser.getAge());
                    return userCrudRepository.save(user);
                }).orElseThrow(() -> new BusinessException(404, "User not found"));
    }

    public void deleteUser(long id){userCrudRepository.deleteById(id);}
}
