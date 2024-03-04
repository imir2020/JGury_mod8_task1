package by.javagur.spring.service;

import by.javagur.spring.database.repository.UserRepository;
import by.javagur.spring.dto.DtoToUser;
import by.javagur.spring.dto.UserToDto;
import by.javagur.spring.mapper.DtoToUserMapper;
import by.javagur.spring.mapper.UserToDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserToDtoMapper userToDtoMapper;
    private final DtoToUserMapper dtoToUserMapper;

    public List<UserToDto> findAll() {
        return userRepository.findAll().stream()
                .map(userToDtoMapper::map)
                .toList();
    }

    public Optional<UserToDto> findById(Long id){
        return userRepository.findById(id)
                .map(userToDtoMapper::map);

    }

    public Optional<UserToDto> findByName(String userName){
        return userRepository.findByUsername(userName).map(userToDtoMapper::map);
    }

    @Transactional
    public UserToDto create(DtoToUser userDto){
        return Optional.of(userDto)
                .map(dtoToUserMapper::map)
                .map(userRepository::save)
                .map(userToDtoMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserToDto> update(Long id, DtoToUser userDto){
        return userRepository.findById(id)
                .map(entity -> dtoToUserMapper.map(userDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userToDtoMapper::map);
    }

    @Transactional
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
