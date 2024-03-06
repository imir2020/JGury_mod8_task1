package by.javagur.spring.database.repository;

import by.javagur.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("select c from Company c " +
           "join fetch c.locales cl " +
           "where c.name = :name")
    Optional<Company> findByName(String name);

    List<Company> findAllByNameContainingIgnoreCase(String fragment);

    List<Company> findAll();

    Optional<Company> findAllById(Integer id);

    Company save(Company company);

    @Modifying
    @Query("""
            update Company c
            set c.name = :companyName
            where c.id= :id """)
    void updateCompanyNameById(String companyName, Integer id);

    void deleteById(Integer id);
}
