package shilaev.librarymanager.models.book;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Book {
    @NotNull(message = "can't be null")
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
    private String isbn;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String title;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private int authorId;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String authorName;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private int yearOfWriting;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    @Range(min = 0, max = Integer.MAX_VALUE)
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
