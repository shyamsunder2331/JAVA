
public class ClientV1 {
    public static void main(String[] args){
        BookCollection bc=new BookCollection();
        bc.addBook(new Book("C++"));
        bc.addBook(new Book("Python"));
        bc.addBook(new Book("Java"));
        bc.addBook(new Book("Rust"));
        for(Book i:bc.getBooks()){
            System.out.println("Book name:"+i.getName());
        }
    }
}
