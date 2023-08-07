package model;

import java.util.List;

public class BookItem {

     BookInfo bookInfo;

     public BookInfo getBookInfo() {
          return bookInfo;
     }

     String copyId;
     Rack rack;

     String borrowedUser;

     public String getBorrowedUser() {
          return borrowedUser;
     }

     public void setBorrowedUser(String borrowedUser) {
          this.borrowedUser = borrowedUser;
     }

     public BookItem(String copyId, BookInfo bookInfo) {
          this.bookInfo=bookInfo;
          this.copyId=copyId;
     }

     public void setRack(Rack rack) {
          this.rack=rack;
     }

     public String getCopyId() {
          return this.copyId;
     }

     public Rack getRack() {
          return this.rack;
     }

}
