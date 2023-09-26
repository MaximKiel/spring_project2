package org.library.services;

import org.library.models.Book;
import org.library.models.Person;
import org.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll(Integer page, Integer booksPerPage, Boolean sortByYear) {
        if (sortByYear != null && sortByYear && page != null && booksPerPage != null) {
            return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("publishYear"))).getContent();
        }
        if (sortByYear != null && sortByYear && page == null && booksPerPage == null) {
            return booksRepository.findAll(Sort.by("publishYear"));
        }
        if (page != null && booksPerPage != null) {
            return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
        }
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
