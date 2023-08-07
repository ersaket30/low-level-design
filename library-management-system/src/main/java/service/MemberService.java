package service;

import model.BookItem;
import model.Library;
import model.Rack;
import repository.BookRepository;
import repository.UserRepository;
import util.LibraryUtil;

import java.util.List;
import java.util.Objects;

public class MemberService {

    int MAX_BOOKS_ALLOWED_TO_BORROW = 2;
    BookRepository bookRepository;

    UserRepository userRepository;
    Library library;

    public MemberService(BookRepository bookRepository, UserRepository userRepository,Library library){
       this.bookRepository = bookRepository;
       this.library = library;
       this.userRepository= userRepository;
    }

    public void borrowBookFromLibrary(String bookId,String user,String dueDate){
        List<BookItem> bookItems = bookRepository.getBooksByBookId(bookId);
        BookItem unBorrowedBook = LibraryUtil.getAvailableBookItem(bookItems);
        if(Objects.isNull(unBorrowedBook)){
            System.out.println("No copies of books available at this instance");
        }
        else if(isBorrowedBooksLimitReached(user)){
            System.out.println("Limit of books to be borrowed is exceeded for user "+user);
        }
        else{
            Rack rack = unBorrowedBook.getRack();
            System.out.println("Borrowed book from rack"+ rack.getRackNo());
            rack.deAllocate();
            unBorrowedBook.setRack(rack);
            unBorrowedBook.setBorrowedUser(user);
            userRepository.addBooksLent(user,unBorrowedBook);
        }
    }

   public void returnBookToLibrary(String bookCopyId){
        BookItem bookItem = bookRepository.getBookByCopyId(bookCopyId);
        List<BookItem> booksBorrowed = userRepository.getBooksLentsByUser(bookItem.getBorrowedUser());
        booksBorrowed.remove(bookItem);
        Rack rack = LibraryUtil.getAvailableRack(library.getRacks());
        rack.allocateRack();
        bookItem.setBorrowedUser(null);
        bookRepository.addBook(bookItem);
        System.out.println("Book copyId is placed at Rack"+rack.getRackNo());

    }
    private boolean isBorrowedBooksLimitReached(String user) {
        List<BookItem> bookItems =userRepository.getBooksLentsByUser(user);
        return Objects.nonNull(bookItems) && !(bookItems.size()<MAX_BOOKS_ALLOWED_TO_BORROW);
    }
}
