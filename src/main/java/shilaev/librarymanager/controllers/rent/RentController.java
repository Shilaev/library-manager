package shilaev.librarymanager.controllers.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shilaev.librarymanager.dao.book.BooksDao;
import shilaev.librarymanager.dao.client.ClientDao;
import shilaev.librarymanager.dao.rent.RentDao;
import shilaev.librarymanager.models.book.Book;
import shilaev.librarymanager.models.client.Client;
import shilaev.librarymanager.models.rent.Rent;

import javax.validation.Valid;

@Controller
@RequestMapping("/rents")
public class RentController {

    private final RentDao rentDao;
    private final ClientDao clientDao;
    private final BooksDao booksDao;

    @Autowired
    public RentController(RentDao rentDao, ClientDao clientDao, BooksDao booksDao) {
        this.rentDao = rentDao;
        this.clientDao = clientDao;
        this.booksDao = booksDao;
    }

    // CREATE
    @GetMapping("/add-rent")
    public String getAddRentPage(@ModelAttribute("new_rent") Rent rent,
                                 @ModelAttribute("client") Client client,
                                 @ModelAttribute("book") Book book,
                                 Model model) {
        model.addAttribute("client_list", clientDao.selectAllClients());
        model.addAttribute("book_list", booksDao.selectAllBooks());
        return "rent/add_rent";
    }

    @PostMapping("/add-rent")
    public String postNewRent(@ModelAttribute("new_rent") @Valid Rent newRent, BindingResult newRentBindingResult,
                              @ModelAttribute("client") Client client,
                              @ModelAttribute("book") Book book,
                              Model model) {

        // SET VALUES
        newRent.setClientId(client.getId());
        newRent.setBookIsbn(book.getIsbn());

        // VALIDATE
        if (newRentBindingResult.hasErrors()){
            model.addAttribute("client_list", clientDao.selectAllClients());
            model.addAttribute("book_list", booksDao.selectAllBooks());
            return "rent/add_rent";
        }

        rentDao.addNewRent(newRent);

        return "redirect:/rents";
    }

    // READ
    @GetMapping()
    public String getRentList(Model model) {
        model.addAttribute("rent_list", rentDao.selectAllRents());
        for (Rent rent : rentDao.selectAllRents()) {
            System.out.println(rent.getId());
        }
        return "rent/all_rents";
    }

    // UPDATE
    // DELETE
}
