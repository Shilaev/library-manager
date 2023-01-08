package shilaev.librarymanager.dao.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import shilaev.librarymanager.models.author.Author;
import shilaev.librarymanager.models.author.AuthorIdLastNameRowMapper;
import shilaev.librarymanager.models.author.AuthorRowMapper;

import java.util.List;

@Component
public class AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAllAuthorLastNames() {
        String selectAllAuthorLastNames = "select * from authors_last_names;";
        return jdbcTemplate.query(selectAllAuthorLastNames, new AuthorIdLastNameRowMapper());
    }

    public Author getAuthorById(int id) {
        String getFromAuthorsById = "select * from authors_last_names where id = ?;";
        return jdbcTemplate.queryForObject(getFromAuthorsById, new AuthorIdLastNameRowMapper(), id);
    }
}
