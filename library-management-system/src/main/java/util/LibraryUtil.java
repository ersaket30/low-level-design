package util;

import model.BookItem;
import model.Rack;

import java.util.List;
import java.util.Objects;

public class LibraryUtil {



    public static Rack getAvailableRack(List<Rack> racks) {
        return racks.stream().filter(Rack::isFree).findFirst().orElse(null);
    }

    public static BookItem getAvailableBookItem(List<BookItem> bookItems) {
        return bookItems.stream().filter(bookItem -> Objects.isNull(bookItem.getBorrowedUser())).findFirst().orElse(null);
    }


}
