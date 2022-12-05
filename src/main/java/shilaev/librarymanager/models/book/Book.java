package shilaev.librarymanager.models.book;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Book {
    @NotNull(message = "can't be null")
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
    private int isbn;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String title;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private int authorId;

    @Length(min = 4, max = 4, message = "year must have 4 chars")
    private int yearOfWriting;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    @Range(min = 0, max = Integer.MAX_VALUE)
    private int unitsInStock;

    public Book(int isbn, String title, int authorId, int yearOfWriting, int unitsInStock) {
        this.isbn = isbn;
        this.title = title;
        this.authorId = authorId;
        this.yearOfWriting = yearOfWriting;
        this.unitsInStock = unitsInStock;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
