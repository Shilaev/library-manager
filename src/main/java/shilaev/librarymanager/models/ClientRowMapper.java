package shilaev.librarymanager.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client newClient = new Client();
        newClient.setId(rs.getInt("id"));
        newClient.setLastName(rs.getString("last_name"));
        newClient.setFirstName(rs.getString("first_name"));
        newClient.setPatronymicName(rs.getString("patronymic_name"));
        newClient.setBirthday(rs.getDate("birthday"));
        newClient.setPhone(rs.getString("phone"));
        newClient.setEmail(rs.getString("email"));
        return newClient;
    }
}
