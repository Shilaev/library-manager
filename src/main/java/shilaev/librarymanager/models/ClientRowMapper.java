package shilaev.librarymanager.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Client(
                rs.getInt("id"),
                rs.getString("last_name"),
                rs.getString("first_name"),
                rs.getString("patronymic_name"),
                rs.getString("birthday"),
                rs.getString("phone"),
                rs.getString("email")
        );
    }
}
