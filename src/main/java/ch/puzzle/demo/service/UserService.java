package ch.puzzle.demo.service;

import ch.puzzle.demo.model.database.User;
import ch.puzzle.demo.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class UserService {
    private final UserCrudRepository userCrudRepository;

    @Autowired
    public UserService(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    public User findUserWithId(Long id) {
        Optional<User> userOptional = this.userCrudRepository.findById(id);
        return  userOptional.orElseThrow(() -> new NotFoundException("User not found"));
    }
}
