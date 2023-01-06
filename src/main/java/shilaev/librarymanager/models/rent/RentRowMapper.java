package shilaev.librarymanager.models.rent;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentRowMapper implements RowMapper<Rent> {
    @Override
    public Rent mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rent rent = new Rent();
        rent.setId(rs.getInt("id"));
        rent.setClientId(rs.getInt("client_id"));
        rent.setBookIsbn(rs.getString("book_isbn"));
        rent.setStart(rs.getDate("rent_start_date"));
        rent.setEnd(rs.getDate("rent_end_date"));
        return rent;
    }
}
