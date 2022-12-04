package shilaev.librarymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shilaev.librarymanager.dao.ClientsDao;
import shilaev.librarymanager.models.Client;


@Controller
@RequestMapping("/clients")
public class ClientsController {
    private final ClientsDao clientsDao;

    @Autowired
    public ClientsController(ClientsDao clientsDao) {
        this.clientsDao = clientsDao;
    }

    // READ
    @GetMapping()
    public String getBooksList(Model model) {
        model.addAttribute("clients_list", clientsDao.selectAllClients());
        return "all_clients";
    }

    @GetMapping("/client/{id}")
    public String getClientPage(@PathVariable("id") int id,
                                Model model) {
        model.addAttribute("currentClient", clientsDao.selectClientById(id));
        return "client_page";
    }

    // CREATE
    @GetMapping("/add-client")
    public String getAddClientPage(@ModelAttribute("new_client") Client newClient) {
        return "add_client";
    }

    @PostMapping("/add-client")
    public String postNewClient(@ModelAttribute("new_client") Client newClient) {
        clientsDao.addNewClient(newClient);
        return "redirect:/clients";
    }

    // UPDATE
    @GetMapping("/edit-client-{id}")
    public String getEditClientPage(@PathVariable("id") int id,
            @ModelAttribute("client_for_edit") Client clientForEdit) {
        return "/edit_client";
    }

    @PatchMapping("/edit-client-{id}")
    public String editClient(@PathVariable("id") int id,
                             @ModelAttribute("edited_client") Client editedClient) {
        clientsDao.editClient(editedClient, id);
        return "redirect:/clients";
    }

}
