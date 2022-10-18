package ch.puzzle.demo.controller;

import ch.puzzle.demo.exception.BusinessException;
import ch.puzzle.demo.model.User;
import ch.puzzle.demo.repository.UserCrudRepository;
import ch.puzzle.demo.repository.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(@RequestParam(required = false) String email) {
        return (List<User>) userService.getAllUsers();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned a users with a specified ID.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Did not find a users with a specified ID.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
        } catch (BusinessException e) {
            return ResponseEntity.status(e.code).body(e.getClientMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        LOG.info("POST payload: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable long id, @RequestBody User newUser) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, newUser));
        } catch (BusinessException e) {
            return ResponseEntity.status(e.code).body(e.getClientMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable long id) {
            userService.deleteUser(id);
        // TODO: 10/18/22 Returns 500 if user not found 
            return ResponseEntity.status(HttpStatus.OK).body("User deleted");
    }
}