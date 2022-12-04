package shilaev.librarymanager.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import shilaev.librarymanager.dao.ClientsDao;
import shilaev.librarymanager.models.Client;

@Component
public class ClientsValidator implements Validator {
    private final ClientsDao clientsDao;

    @Autowired
    public ClientsValidator(ClientsDao clientsDao) {
        this.clientsDao = clientsDao;
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
