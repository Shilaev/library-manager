package shilaev.librarymanager.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import shilaev.librarymanager.models.Client;

public class ClientsValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;
        if (client.getLastName().isEmpty()) {
            errors.rejectValue("last_name", "can't be empty");
        }
    }
}
