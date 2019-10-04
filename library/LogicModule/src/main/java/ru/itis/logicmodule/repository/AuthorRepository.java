package ru.itis.logicmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.logicmodule.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByName(String name);
    List<Author> findAll();
    Optional<Author> findById(Long id);
    boolean existsByName(String name);
    void deleteById(Long id);
}
