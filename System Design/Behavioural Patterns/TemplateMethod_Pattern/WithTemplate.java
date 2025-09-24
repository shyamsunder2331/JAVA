abstract class DataParser{
    public void parse(){
        openFile();
        parseFile();
        closeFile();
    }
    public void openFile(){
        System.out.println("Opening the file");
    }
    public abstract void parseFile();
    public void closeFile(){
        System.out.println("Closing the file");
    }
}
class CSVParser extends DataParser{
    @Override
    public void parseFile(){
        System.out.println("parsing the CSV file");
    }
}
class JSONParser extends DataParser{
    @Override
    public void parseFile(){
        System.out.println("parsing the JSON file");
    }
}
public class WithTemplate {
    public static void main(String[] args){
        DataParser csv=new CSVParser();
        csv.parse();
        DataParser jsn=new JSONParser();
        jsn.parse();
    }
}
