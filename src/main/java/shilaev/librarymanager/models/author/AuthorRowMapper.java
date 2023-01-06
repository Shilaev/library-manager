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
//        authors.setFirstName(rs.getString("first_name"));
//        authors.setPatronymicName(rs.getString("patronymic_name"));
//        authors.setBirthday(rs.getDate("birthday"));
//        authors.setDeathDay(rs.getDate("death_date"));
        return author;
    }
}
