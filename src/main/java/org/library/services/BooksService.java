package org.library.services;

import org.library.models.Book;
import org.library.models.Person;
import org.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    public List<Book> findByTitleStartingWith(String search) {
        if (search != null) {
            return booksRepository.findByTitleStartingWith(search);
        }
        return null;
    }

    @Transactional
    public void save(Book book) {
        book.setIssuanceTime(new Date());
        book.setOverdue(false);
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        Book bookToUpdate = booksRepository.findById(id).get();
        updatedBook.setId(id);
        updatedBook.setOwner(bookToUpdate.getOwner());
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public void release(int id) {
        booksRepository.findById(id).ifPresent(book -> {
            book.setOwner(null);
            book.setIssuanceTime(null);
        });
    }

    @Transactional
    public void assign(int id, Person person) {
        booksRepository.findById(id).ifPresent(book -> {
            book.setOwner(person);
            book.setIssuanceTime(new Date());
        });
    }
}
