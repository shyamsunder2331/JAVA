class CSVParser{
    public CSVParser(){
        openFile();
        //parserCSV
        closeFile();
    }
    private void openFile(){
        System.out.println("Opening the CSV file..");
    }
    private void closeFile(){
        System.out.println("Closing the CSV file");
    }
}
class JSONParser{
    public JSONParser(){
        openFile();
        //parserCSV
        closeFile();
    }
    private void openFile(){
        System.out.println("Opening the JSON file..");
    }
    private void closeFile(){
        System.out.println("Closing the JSON file");
    }
}
public class WithoutTemplate{
    public static void main(String[] args) {
        CSVParser cs=new CSVParser();
        JSONParser js=new JSONParser();
    }
}