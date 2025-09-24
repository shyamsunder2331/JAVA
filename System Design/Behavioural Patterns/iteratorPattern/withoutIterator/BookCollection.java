
import java.util.*;
public class BookCollection{
    private ArrayList<Book> bookCollection;
    public BookCollection(){
        this.bookCollection=new ArrayList<>();
    }
    public void addBook(Book book){
        this.bookCollection.add(book);
    }
    public ArrayList<Book> getBooks(){
        return this.bookCollection;
    }

}