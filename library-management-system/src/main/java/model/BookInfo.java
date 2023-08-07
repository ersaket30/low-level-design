package model;

import java.util.List;

public class BookInfo {

    String bookId;
    String title;
    List<Author> authors;
    List<Publisher> publishers;

    public String getBookId() {
        return bookId;
    }

    public BookInfo(String bookId, String title, List<Author> authors, List<Publisher> publishers) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
    }
}
