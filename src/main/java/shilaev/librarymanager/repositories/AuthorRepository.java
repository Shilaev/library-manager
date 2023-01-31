package shilaev.librarymanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shilaev.librarymanager.models.author.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
