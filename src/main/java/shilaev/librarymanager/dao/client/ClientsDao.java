package shilaev.librarymanager.dao.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import shilaev.librarymanager.models.client.ClientRowMapper;
import shilaev.librarymanager.models.client.Client;

import java.util.List;

// TODO: 03.01.2023 create VIEW on update table. Select VIEW - select all clients

@Component
public class ClientsDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public void addNewClient(Client newClient) {
        String insertIntoClientsView = "insert into clients_all_info (last_name, first_name, patronymic_name, birthday, phone, email)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";

//        String insertIntoClientsQuery = "insert into clients (" +
//                "last_name," +
//                "first_name," +
//                "patronymic_name," +
//                "birthday," +
//                "phone," +
//                "email) values (?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(insertIntoClientsView,
                newClient.getLastName(),
                newClient.getFirstName(),
                newClient.getPatronymicName(),
                newClient.getBirthday(),
                newClient.getPhone(),
                newClient.getEmail());
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

    // UPDATE
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

    // DELETE
    public void deleteClientById(int id) {
        String deleteFromClient = "delete from clients where id = ?;";
        jdbcTemplate.update(deleteFromClient, id);
    }
}
