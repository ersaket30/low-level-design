import model.*;
import repository.BookRepository;
import repository.UserRepository;
import service.LibrarianService;
import service.MemberService;

import java.util.Arrays;


//https://workat.tech/machine-coding/practice/design-library-management-system-jgjrv8q8b136
public class Driver {

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();
        UserRepository userRepository = new UserRepository();
        LibrarianService librarianService = new LibrarianService(bookRepository,userRepository);

        BookInfo bookInfo = new BookInfo("1","Java", Arrays.asList(new Author("Niharika")),Arrays.asList(new Publisher("Vijay publications")));
        BookItem bookItem = new BookItem("11",bookInfo);

        librarianService.createLibrary("My Library",new Address("Hyderabad"),15);
        MemberService memberService = new MemberService(bookRepository,userRepository,Library.getInstance());
        librarianService.addBooksToLibrary(bookInfo,20);
        librarianService.removeBookFromLibrary("1_10");

        memberService.borrowBookFromLibrary("1","Niharika","2022-01-21");
        memberService.borrowBookFromLibrary("1","Niharika","2022-01-21");
        memberService.borrowBookFromLibrary("1","Niharika","2022-01-21");

        memberService.returnBookToLibrary("1_1");
        memberService.borrowBookFromLibrary("1","Niharika","2022-01-21");
        memberService.borrowBookFromLibrary("1","Niha","2022-01-21");
        memberService.borrowBookFromLibrary("1","Niha","2022-01-21");
        memberService.returnBookToLibrary("1_2");
        memberService.borrowBookFromLibrary("1","Jeevan","2022-01-21");
    }
}
