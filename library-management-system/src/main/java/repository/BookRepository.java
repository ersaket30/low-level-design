package repository;

import model.BookItem;

import java.util.*;

public class BookRepository {

    Map<String, List<BookItem>> bookIdItemsMap;
    Map<String,BookItem> copyIdbookItemMap;

    public BookRepository(){
        copyIdbookItemMap=new HashMap<>();
        bookIdItemsMap = new HashMap<>();
    }

    public void addBook(BookItem bookItem) {
        String bookId = bookItem.getBookInfo().getBookId();
        if(Objects.isNull(bookIdItemsMap.get(bookId))){
            bookIdItemsMap.put(bookId,new ArrayList<>());
        }
        bookIdItemsMap.get(bookId).add(bookItem);
        copyIdbookItemMap.put(bookItem.getCopyId(),bookItem);
    }

    public BookItem getBookByCopyId(String bookCopyId) {
        return copyIdbookItemMap.get(bookCopyId);
    }

    public List<BookItem> getBooksByBookId(String bookId) {
        return bookIdItemsMap.get(bookId);
    }

    public void deleteBookByCopyId(String bookCopyId) {
        copyIdbookItemMap.remove(bookCopyId);
    }
}
