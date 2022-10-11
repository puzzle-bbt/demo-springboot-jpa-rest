package ch.puzzle.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import ch.puzzle.demo.model.User;

public interface UserCrudRepository extends CrudRepository<User, Long>, QueryByExampleExecutor<User> {
}
