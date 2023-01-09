package shilaev.librarymanager.models.author;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
public class Author {
    @NotNull(message = "can't be null")
    private int id;

    @NotEmpty(message = "can't be empty")
    private String lastName;

    @NotEmpty(message = "can't be empty")
    private String firstName;

    @NotEmpty(message = "can't be empty")
    private String patronymicName;

    @NotNull(message = "can't be null")
    private Date birthday;

    @NotNull(message = "can't be null")
    private Date deathDay;

    public Author(String lastName, String firstName, String patronymicName, Date birthday, Date deathDay) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.birthday = birthday;
        this.deathDay = deathDay;
    }
}
