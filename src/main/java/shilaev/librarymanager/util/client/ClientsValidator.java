package shilaev.librarymanager.util.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import shilaev.librarymanager.dao.client.ClientDao;
import shilaev.librarymanager.models.client.Client;

@Component
public class ClientsValidator implements Validator {
    private final ClientDao clientDao;

    @Autowired
    public ClientsValidator(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;

        // LAST NAME CAN'T BE EMPTY
        if (((Client) target).getLastName().equals("")) {
            errors.rejectValue("lastName", "", "can't be empty");
        }
    }
}
