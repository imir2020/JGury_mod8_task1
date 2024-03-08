package by.javagur.spring.database.repository;

import by.javagur.spring.database.entity.Role;
import by.javagur.spring.database.entity.User;
import by.javagur.spring.dto.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,
        FilterUserRepository, QuerydslPredicateExecutor<User> {

    List<User> findAll();

    Page<User> findAllBy(Pageable pageable);

    List<User> findAllByCompanyId(Integer id);

    List<User> findAllByFilter(UserFilter userFilter);

    List<User> findFirst3By(Sort sort);

    @Query("select u from User u " +
           "where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String userName);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role " +
           "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    User save(User user);

    User saveAndFlush(User user);

    void deleteById(Long id);
}
