package by.javagur.spring.services;

import by.javagur.spring.dto.CompanyToDto;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<CompanyToDto> findById(Integer id);
    List<CompanyToDto> findAll();

}
