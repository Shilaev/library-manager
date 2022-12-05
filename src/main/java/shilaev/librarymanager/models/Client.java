package shilaev.librarymanager.models;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.sql.Date;

public class Client {
    @NotNull(message = "can't be null")
    @Range(min = 0, max = Integer.MAX_VALUE)
    private int id;

    @Length(min = 1, max = 90, message = "Length must be between 1 and 90")
    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String lastName;

    @Length(min = 1, max = 90, message = "Length must be between 1 and 90")
    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String firstName;

    @Length(min = 1, max = 90, message = "Length must be between 1 and 90")
    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String patronymicName;

    @NotNull
    private Date birthday;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$",
            message = "phone number format must be: +1(234)568-8910")
    private String phone;

    @Email(message = "check correction of email adres")
    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String email;

    public Client(int id, String lastName, String firstName, String patronymicName, Date birthday, String phone, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }
}
