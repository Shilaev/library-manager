package shilaev.librarymanager.models.client;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "can't be null")
    @Range(min = 0, max = Integer.MAX_VALUE)
    private int id;

    @Length(min = 1, max = 90, message = "Length must be between 1 and 90")
    @NotEmpty(message = "can't be empty")
    @Column(name = "last_name")
    private String lastName;

    @Length(min = 1, max = 90, message = "Length must be between 1 and 90")
    @NotEmpty(message = "can't be empty")
    @Column(name = "first_name")
    private String firstName;

    @Length(min = 1, max = 90, message = "Length must be between 1 and 90")
    @NotEmpty(message = "can't be empty")
    @Column(name = "patronymic_name")
    private String patronymicName;

    @NotNull
    @Column(name = "birthday")
    private Date birthday;

    @NotNull(message = "can't be null")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$",
            message = "phone number format must be: +1(234)568-8910")
    @Column(name = "phone")
    private String phone;

    @Email(message = "check correction of email adres")
    @NotEmpty(message = "can't be empty")
    @Column(name = "email")
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
}
