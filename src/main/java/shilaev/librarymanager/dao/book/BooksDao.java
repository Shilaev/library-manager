package shilaev.librarymanager.dao.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import shilaev.librarymanager.models.book.Book;
import shilaev.librarymanager.models.book.BookRowMapper;

import java.util.List;

@Component
public class BooksDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BooksDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // READ
    public List<Book> selectAllBooks() {
        String selectAllFromBooksLeftJoinAuthor = "select books.isbn, books.title, books.author_id, author.last_name, books.year_of_writing, books.units_in_stock\n" +
                "from books\n" +
                "left join authors author on books.author_id = author.id";

        return jdbcTemplate.query(selectAllFromBooksLeftJoinAuthor, new BookRowMapper());
    }

    // CREATE
    public void addNewBook(Book newBook) {
        String insertRequest = "insert into books (isbn, title, author_id, last_name, year_of_writing, units_in_stock)\n" +
                "values (?,?,?,?,?,?);";
        jdbcTemplate.update(insertRequest,
                newBook.getIsbn(),
                newBook.getTitle(),
                newBook.getAuthorId(),
                newBook.getAuthorLastName(),
                newBook.getYearOfWriting(),
                newBook.getUnitsInStock());
    }
}
