package shilaev.librarymanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shilaev.librarymanager.models.author.Author;
import shilaev.librarymanager.repositories.AuthorRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
