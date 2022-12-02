package shilaev.librarymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shilaev.librarymanager.dao.ClientsDao;

@Controller
@RequestMapping("/clients")
public class ClientsController {
    private final ClientsDao clientsDao;

    @Autowired
    public ClientsController(ClientsDao clientsDao) {
        this.clientsDao = clientsDao;
    }

    @GetMapping()
    public String getBooksList(Model model) {
        model.addAttribute("clients_list", clientsDao.selectAllClients());
        return "clients_list";
    }
}
