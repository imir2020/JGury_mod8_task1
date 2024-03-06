package by.javagur.spring.services.impl;

import by.javagur.spring.database.repository.UserRepository;
import by.javagur.spring.dto.DtoToUser;
import by.javagur.spring.dto.UserToDto;
import by.javagur.spring.mapper.DtoToUserMapper;
import by.javagur.spring.mapper.UserToDtoMapper;
import by.javagur.spring.services.UserService;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToDtoMapper userToDtoMapper;
    private final DtoToUserMapper dtoToUserMapper;

    @Override
    public List<UserToDto> findAll() {
        return userRepository.findAll().stream()
                .map(userToDtoMapper::map)
                .toList();
    }

    @Override
    public Optional<UserToDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userToDtoMapper::map);

    }

    @Override
    public Optional<UserToDto> findByName(String userName) {
        return userRepository.findByUsername(userName).map(userToDtoMapper::map);
    }


    @Transactional
    @Override
    public UserToDto create(DtoToUser dtoToUser) {
        return Optional.of(dtoToUser)
                .map(dtoToUserMapper::map)
                .map(userRepository::save)
                .map(userToDtoMapper::map)
                .orElseThrow();
    }


    @Transactional
    @Override
    public Optional<UserToDto> update(Long id, DtoToUser dtoToUser) {
        return userRepository.findById(id)
                .map(entity -> dtoToUserMapper.map(dtoToUser, entity))
                .map(userRepository::saveAndFlush)
                .map(userToDtoMapper::map);
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.deleteById(entity.getId());
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
