package shilaev.librarymanager.models.rent;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

public class Rent {
    @NotNull(message = "can't be null")
    private int id;

    @NotNull(message = "can't be null")
    private int clientId;

//    @NotEmpty(message = "can't be empty")
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
            message = "must be in ISBN format")
    private String bookIsbn;

    @NotNull(message = "can't be null")
    private Date start;

    @NotNull(message = "can't be null")
    private Date end;

    public Rent(int clientId, String bookIsbn, Date start, Date end) {
        this.clientId = clientId;
        this.bookIsbn = bookIsbn;
        this.start = start;
        this.end = end;
    }

    public Rent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
