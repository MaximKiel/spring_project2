package org.library.dao;

import org.springframework.stereotype.Component;

@Component
public class BookDAO {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Book> index() {
//        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public Book show(int id) {
//        return jdbcTemplate.query("SELECT * FROM book WHERE id=?",
//                new Object[]{id},
//                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
//    }
//
//    public void save(Book book) {
//        jdbcTemplate.update("INSERT INTO book(title, author_name, publish_year) VALUES (?, ?, ?)",
//                book.getTitle(), book.getAuthorName(), book.getPublishYear());
//    }
//
//    public void update(int id, Book updatedBook) {
//        jdbcTemplate.update("UPDATE book SET title=?, author_name=?, publish_year=? WHERE id=?",
//                updatedBook.getTitle(), updatedBook.getAuthorName(), updatedBook.getPublishYear(), id);
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
//    }
//
//    public Optional<Person> getBookOwner(int id) {
//        return jdbcTemplate.query("SELECT person.* FROM book JOIN person ON book.person_id = person.id " +
//                        "WHERE book.id = ?",
//                new Object[]{id},
//                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
//    }
//
//    public void release(int id) {
//        jdbcTemplate.update("UPDATE book SET person_id=NULL WHERE id=?", id);
//    }
//
//    public void assign(int id, Person person) {
//        jdbcTemplate.update("UPDATE book SET person_id=? WHERE id=?", person.getId(), id);
//    }
}
