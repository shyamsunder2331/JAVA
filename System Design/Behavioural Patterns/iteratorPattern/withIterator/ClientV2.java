import java.util.*;
class ClientV2{
    public static void main(String[] args){
        BookCollectionII bc=new BookCollectionII();
        bc.addBook(new BookII("C++"));
        bc.addBook(new BookII("Python"));
        bc.addBook(new BookII("Java"));
        bc.addBook(new BookII("Rust"));
        Iterator<BookII> it=bc.createIterator();
        while(it.hasNext()){
            System.out.println(it.next().getName());
        }
    }
}