package org.library.dao;

import org.springframework.stereotype.Component;

@Component
public class PersonDAO {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PersonDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Person> index() {
//        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
//    }
//
//    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * FROM person WHERE id=?",
//                new Object[]{id},
//                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
//    }
//
//    public void save(Person person) {
//        jdbcTemplate.update("INSERT INTO person(name, birth_year) VALUES(?, ?)",
//                person.getName(), person.getBirthYear());
//    }
//
//    public void update(int id, Person updatedPerson) {
//        jdbcTemplate.update("UPDATE person SET name=?, birth_year=? WHERE id=?",
//                updatedPerson.getName(), updatedPerson.getBirthYear(), id);
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
//    }
//
//    public Optional<Person> getPersonByFullName(String name) {
//        return jdbcTemplate.query("SELECT * FROM person WHERE name=?",
//                new Object[]{name},
//                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
//    }
//
//    public List<Book> showBooks(int id) {
//        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?",
//                new Object[]{id},
//                new BeanPropertyRowMapper<>(Book.class));
//    }
}
