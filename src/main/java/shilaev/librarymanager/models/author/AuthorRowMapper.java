package shilaev.librarymanager.models.author;

import org.springframework.jdbc.core.RowMapper;
import shilaev.librarymanager.models.book.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setLastName(rs.getString("last_name"));
        author.setFirstName(rs.getString("first_name"));
        author.setPatronymicName(rs.getString("patronymic_name"));
        author.setBirthday(rs.getDate("birthday"));
        author.setDeathDay(rs.getDate("death_date"));
        return author;
    }
}
