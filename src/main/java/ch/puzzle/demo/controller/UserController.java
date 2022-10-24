package ch.puzzle.demo.controller;

import ch.puzzle.demo.model.database.User;
import ch.puzzle.demo.repository.UserCrudRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private final UserCrudRepository userCrudRepository;

    public UserController(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @GetMapping("users")
    public List<User> getAllUsers(@RequestParam(required = false) String email) {
        return (List<User>) userCrudRepository.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned a users with a specified ID.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Did not find a users with a specified ID.", content = @Content)
    })
    @GetMapping("users/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
        return userCrudRepository.findById(id);
    }

    @PostMapping("users")
    public User saveUser(@RequestBody User user) {
        LOG.info("POST payload: {}", user);
        return this.userCrudRepository.save(user);
    }
}