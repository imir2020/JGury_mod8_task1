package by.javagur.spring.services;

import by.javagur.spring.dto.DtoToUser;
import by.javagur.spring.dto.UserToDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserToDto> findAll();
    Optional<UserToDto> findById(Long id);
    Optional<UserToDto> findByName(String userName);
    UserToDto create(DtoToUser dtoToUser);
    Optional<UserToDto> update(Long id, DtoToUser dtoToUser);
    boolean delete(Long id);
}
