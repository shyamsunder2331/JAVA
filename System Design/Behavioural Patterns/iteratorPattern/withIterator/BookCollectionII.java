import java.util.*;
public class BookCollectionII{
    private ArrayList<BookII> bookCollectionII;
    public BookCollectionII(){
        this.bookCollectionII=new ArrayList<>();
    }
    public void addBook(BookII book){
        this.bookCollectionII.add(book);
    }
    public Iterator<BookII> createIterator(){
        return new BookIterator(this.bookCollectionII);
    }
    public class BookIterator implements Iterator<BookII>{
        ArrayList<BookII> list=new ArrayList<>();
        int position=0;
        public BookIterator(ArrayList<BookII> book){
            this.list=book;
        }
        public boolean hasNext(){
                return position<list.size();
        }
        public BookII next(){
            return list.get(position++);

        }
    }
}