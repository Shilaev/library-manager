package shilaev.librarymanager.models.book;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setIsbn(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        book.setAuthorId(rs.getInt("author_id"));
        book.setAuthorLastName(rs.getString("last_name"));
        book.setYearOfWriting(rs.getInt("year_of_writing"));
        book.setUnitsInStock(rs.getInt("units_in_stock"));
        return book;
    }
}
