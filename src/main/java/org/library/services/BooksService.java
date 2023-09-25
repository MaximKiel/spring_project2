package org.library.services;

import org.library.models.Book;
import org.library.models.Person;
import org.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

//    Книг может быть много и они могут не помещаться на одной странице в браузере.
//    Чтобы решить эту проблему, метод контроллера должен уметь выдавать не только все книги разом,
//    но и разбивать выдачу на страницы.

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public void release(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        if (foundBook.isPresent()) {
            Book book = foundBook.get();
            book.setOwner(null);
        }
    }

    @Transactional
    public void assign(int id, Person person) {
        Optional<Book> foundBook = booksRepository.findById(id);
        if (foundBook.isPresent()) {
            Book book = foundBook.get();
            book.setOwner(person);
        }
    }
}
