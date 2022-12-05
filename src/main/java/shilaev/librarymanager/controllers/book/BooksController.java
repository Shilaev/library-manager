package shilaev.librarymanager.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shilaev.librarymanager.dao.book.BooksDao;
import shilaev.librarymanager.util.book.BooksValidator;

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
    @GetMapping()
    public String getAllBooks(Model model) {
        model.addAttribute("books_list", booksDao.getAllBooks());
        return "book/all_books";
    }

    // UPDATE


    // DELETE

}
