package by.javagur.spring.database.repository;

import by.javagur.spring.database.entity.User;
import by.javagur.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);
}
