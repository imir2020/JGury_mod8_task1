package by.javagur.spring.service;

import by.javagur.spring.database.repository.UserRepository;
import by.javagur.spring.dto.UserCreateEditDto;
import by.javagur.spring.dto.UserReadDto;
import by.javagur.spring.mapper.UserCreateEditMapper;
import by.javagur.spring.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
@ToString
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findById(Long id){
        return userRepository.findById(id)
                .map(userReadMapper::map);

    }

    public UserReadDto create(UserCreateEditDto userDto){
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    public Optional<UserReadDto> update(Long id, UserCreateEditDto userDto){
        return userRepository.findById(id)
                .map(entity -> userCreateEditMapper.map(userDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
