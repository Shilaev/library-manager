package shilaev.librarymanager.controllers.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @GetMapping("")
    public String getAllBooksList() {
        return "book/all_books";
    }
}
