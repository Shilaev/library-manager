package shilaev.librarymanager.models.book;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Year;
import java.util.Date;

public class Book {
    @NotEmpty(message = "can't be empty")
//    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
//            message = "must be in ISBN format")
    private String isbn;

    @NotEmpty(message = "can't be empty")
    private String title;
    //    @NotNull(message = "can't be null")
    private int authorId;
    //    @NotEmpty(message = "can't be empty")
    private String authorName;

    @NotNull(message = "can't be null")
    private int yearOfWriting;

    @NotNull(message = "can't be null")
    @Range(min = 0, max = Integer.MAX_VALUE,
            message = "must be greater then 0")
    private int unitsInStock;

    public Book(String isbn, String title, String authorName, int yearOfWriting, int unitsInStock) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.yearOfWriting = yearOfWriting;
        this.unitsInStock = unitsInStock;
    }

    public Book(String isbn, String title, int authorId, int yearOfWriting, int unitsInStock) {
        this.isbn = isbn;
        this.title = title;
        this.authorId = authorId;
        this.yearOfWriting = yearOfWriting;
        this.unitsInStock = unitsInStock;
    }

    public Book() {

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getYearOfWriting() {
        return yearOfWriting;
    }

    public void setYearOfWriting(int yearOfWriting) {
        this.yearOfWriting = yearOfWriting;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
}
