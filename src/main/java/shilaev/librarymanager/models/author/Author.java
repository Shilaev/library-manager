package shilaev.librarymanager.models.author;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Author {
    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private int id;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String lastName;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String firstName;

    private String patronymicName;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private Date birthday;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private Date deathDay;

    public Author(String lastName, String firstName, String patronymicName, Date birthday, Date deathDay) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.birthday = birthday;
        this.deathDay = deathDay;
    }

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Date deathDay) {
        this.deathDay = deathDay;
    }
}
