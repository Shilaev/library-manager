package shilaev.librarymanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import shilaev.librarymanager.models.ClientRowMapper;
import shilaev.librarymanager.models.Client;

import java.util.List;

@Component
public class ClientsDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> selectAllClients() {
        String query = "select * from clients;";
        return jdbcTemplate.query(query, new ClientRowMapper());
    }
}
