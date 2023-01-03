package shilaev.librarymanager.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shilaev.librarymanager.dao.book.BooksDao;
import shilaev.librarymanager.models.book.Book;
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
    @GetMapping("/add-book")
    public String addBookPage(@ModelAttribute("new_book") Book newBook) {
        return "book/add_book";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute("new_book")
                          @Valid Book newBook,
                          BindingResult bindingResult) {
        booksValidator.validate(newBook, bindingResult);
        if (bindingResult.hasErrors()) {
            return "book/add_book";
        }

        booksDao.addNewBook(newBook);
        return "redirect:/books";
    }

    // READ
    @GetMapping()
    public String getAllBooks(Model model) {
        model.addAttribute("books_list", booksDao.getAllBooks());
        return "book/all_books";
    }

    // UPDATE


    // DELETE

}
