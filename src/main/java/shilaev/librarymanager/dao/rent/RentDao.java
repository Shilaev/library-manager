package shilaev.librarymanager.dao.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import shilaev.librarymanager.models.rent.Rent;
import shilaev.librarymanager.models.rent.RentRowMapper;

import java.util.List;

@Component
public class RentDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public RentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Rent> selectAllRents() {
        String selectAllFromRents = "select * from rents;";
        return jdbcTemplate.query(selectAllFromRents, new RentRowMapper());
    }

    public void addNewRent(Rent newRent) {
        String insertNewRent = "insert into rents (" +
                "client_id," +
                "book_isbn," +
                "rent_start_date," +
                "rent_end_date)\n" +
                "VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(insertNewRent,
                newRent.getClientId(),
                newRent.getBookIsbn(),
                newRent.getStart(),
                newRent.getEnd());
    }
}
