package repository;

import model.BookItem;

import java.util.*;

public class UserRepository {

    Map<String, List<BookItem>> userBooksMap;

    public UserRepository(){
        userBooksMap = new HashMap<>();
    }

    public void addBooksLent(String user, BookItem borrowedBook) {
        if(userBooksMap.get(user)==null){
            userBooksMap.put(user,new ArrayList<>());
        }
        userBooksMap.get(user).add(borrowedBook);
    }

    public List<BookItem> getBooksLentsByUser(String user) {
        return userBooksMap.get(user);
    }


}
