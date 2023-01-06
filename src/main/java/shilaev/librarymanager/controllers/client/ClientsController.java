package shilaev.librarymanager.controllers.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shilaev.librarymanager.dao.client.ClientsDao;
import shilaev.librarymanager.models.client.Client;
import shilaev.librarymanager.util.client.ClientsValidator;

import javax.validation.Valid;


@Controller
@RequestMapping("/clients")
public class ClientsController {
    private final ClientsValidator clientsValidator;
    private final ClientsDao clientsDao;

    @Autowired
    public ClientsController(ClientsValidator clientsValidator, ClientsDao clientsDao) {
        this.clientsValidator = clientsValidator;
        this.clientsDao = clientsDao;
    }

    // CREATE
    @GetMapping("/add-client")
    public String getAddClientPage(@ModelAttribute("new_client") Client newClient) {
        return "client/add_client";
    }

    @PostMapping("/add-client")
    public String postNewClient(@ModelAttribute("new_client")
                                @Valid Client newClient,
                                BindingResult bindingResult) {
        clientsValidator.validate(newClient, bindingResult);
        if (bindingResult.hasErrors()) {
            return "client/add_client";
        }

        clientsDao.addNewClient(newClient);
        return "redirect:/clients";
    }

    // READ
    @GetMapping()
    public String getBooksList(Model model) {
        model.addAttribute("clients_list", clientsDao.selectAllClients());
        return "client/all_clients";
    }

    @GetMapping("/client/{id}")
    public String getClientPage(@PathVariable("id") int id,
                                Model model) {
        model.addAttribute("currentClient", clientsDao.selectClientById(id));
        return "client/client_page";
    }

    // UPDATE
    @GetMapping("/edit-client-{id}")
    public String getEditClientPage(@PathVariable("id") int id,
                                    Model model) {
        model.addAttribute("edited_client", clientsDao.selectClientById(id));
        return "client/edit_client";
    }

    @PatchMapping("/edit-client-{id}")
    public String editClient(@PathVariable("id") int id,
                             @ModelAttribute("edited_client")
                             @Valid Client editedClient,
                             BindingResult bindingResult) {
        clientsValidator.validate(editedClient, bindingResult);
        if (bindingResult.hasErrors()) {
            return "client/edit_client";
        }

        clientsDao.editClient(editedClient, id);
        return "redirect:/clients/client/" + id;
    }

    // DELETE
    @DeleteMapping("/delete-client-{id}")
    public String deleteClient(@PathVariable("id") int id) {
        clientsDao.deleteClientById(id);
        return "redirect:/clients";
    }

}
