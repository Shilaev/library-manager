package shilaev.librarymanager.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shilaev.librarymanager.dao.book.BooksDao;
import shilaev.librarymanager.models.client.Client;
import shilaev.librarymanager.util.book.BooksValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BooksValidator booksValidator;
    private final BooksDao booksDao;

    @Autowired
    public BooksController(BooksValidator booksValidator, BooksDao booksDao) {
        this.booksValidator = booksValidator;
        this.booksDao = booksDao;
    }


    // CREATE


    // READ


    // UPDATE


    // DELETE

}
