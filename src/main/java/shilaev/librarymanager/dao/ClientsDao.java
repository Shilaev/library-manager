package shilaev.librarymanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    // READ
    public List<Client> selectAllClients() {
        String selectAllFromClients = "select * from clients;";
        return jdbcTemplate.query(selectAllFromClients, new ClientRowMapper());
    }

    public Client selectClientById(int id) {
        String selectClientById = "select * from clients where id = ?;";
        return jdbcTemplate.queryForObject(selectClientById, new ClientRowMapper(), id);
    }

    // CREATE
    public void addNewClient(Client newClient) {
        String insertIntoClientsQuery = "insert into clients (" +
                "last_name," +
                "first_name," +
                "patronymic_name," +
                "birthday," +
                "phone," +
                "email) values (?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(insertIntoClientsQuery,
                newClient.getLastName(),
                newClient.getFirstName(),
                newClient.getPatronymicName(),
                newClient.getBirthday(),
                newClient.getPhone(),
                newClient.getEmail());
    }

    public void editClient(Client newClient, int id) {
        String updateClient = "update clients\n" +
                "set last_name = ?,\n" +
                "    first_name = ?,\n" +
                "    patronymic_name = ?,\n" +
                "    birthday = ?,\n" +
                "    phone = ?,\n" +
                "    email = ?\n" +
                "where id = ?;";

        jdbcTemplate.update(updateClient,
                newClient.getLastName(),
                newClient.getFirstName(),
                newClient.getPatronymicName(),
                newClient.getBirthday(),
                newClient.getPhone(),
                newClient.getEmail(),
                id);
    }
}
