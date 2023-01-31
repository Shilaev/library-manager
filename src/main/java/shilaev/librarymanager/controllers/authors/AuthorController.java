package shilaev.librarymanager.controllers.authors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shilaev.librarymanager.models.author.Author;
import shilaev.librarymanager.services.AuthorService;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public String getAllAuthors() {
        List<Author> authorList = authorService.getAllAuthors();
        authorList.forEach(author -> {
            System.out.println(author.getLastName());
        });
        return "";
    }
}
