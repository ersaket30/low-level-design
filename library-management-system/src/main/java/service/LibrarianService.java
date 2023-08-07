package service;

import model.*;
import repository.BookRepository;
import repository.UserRepository;
import util.LibraryUtil;

import java.util.List;
import java.util.Objects;

public class LibrarianService {

    BookRepository bookRepository;
    UserRepository userRepository;
    Library library;

    public LibrarianService(BookRepository bookRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.library = Library.getInstance();
        this.userRepository = userRepository;
    }

   public String createLibrary(String name, Address address,int noOfRacks){
        library = Library.createInstance(name,address,noOfRacks);
        return "Library Created";
    }

   public void addBooksToLibrary(BookInfo bookInfo, int noOfCopies){

        String bookId = bookInfo.getBookId();

        for(int i=1;i<=noOfCopies;i++){
            Rack rack = LibraryUtil.getAvailableRack(library.getRacks());
            if(Objects.isNull(rack)){
                System.out.println("Rack Not Available");
                break;
            }else{
                BookItem bookItem = new BookItem(bookId+"_"+i,bookInfo);
                bookItem.setRack(rack);
                bookItem.getRack().allocateRack();
                bookRepository.addBook(bookItem);
                System.out.println("BookItem with copyId "+bookId+"_"+i+ "is alloted to rack"+bookItem.getRack().getRackNo());
            }
        }
    }

    public void removeBookFromLibrary(String bookCopyId){
        BookItem bookItem = bookRepository.getBookByCopyId(bookCopyId);
        bookItem.getRack().deAllocate();
        bookRepository.deleteBookByCopyId(bookCopyId);
        System.out.println("Removed "+bookCopyId+" from rack"+bookItem.getRack().getRackNo());
    }

    void booksLentByUser(String userId){
        List<BookItem> bookItemList = userRepository.getBooksLentsByUser(userId);
        for(BookItem bookItem: bookItemList){

        }

    }




}
