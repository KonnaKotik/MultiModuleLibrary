package ru.itis.logicmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.logicmodule.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    List<Book> findAllByAuthor_Id(Long authorId);

    void deleteBookById(Long id);

    Optional<Book> findBookByTitle(String title);


}
