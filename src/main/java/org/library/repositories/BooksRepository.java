package org.library.repositories;

import org.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

//    Добавить сортировку книг по году. Метод контроллера должен уметь выдавать книги в отсортированном порядке.

//    Создать страницу поиска книг. Вводим в поле на странице начальные буквы
//    названия книги, получаем полное название книги и имя автора. Также, если
//    книга сейчас находится у кого-то, получаем имя этого человека.
//    Поиск должен производиться по начальным буквам названия книги (с помощью JPA репозитория)
}
