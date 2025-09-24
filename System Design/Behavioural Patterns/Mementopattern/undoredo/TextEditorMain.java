
public class TextEditorMain {
    public static void main(String[] args){

        TextEditor te=new TextEditor();
        te.write("Hello shyamsunder");
        careTaker ct=new careTaker();
        ct.saveState(te);
        te.write("Hello EveryOne......");
        ct.saveState(te);
        System.out.println(te.getContent());
        te.write("This is shyamsunder");
        ct.saveState(te);
        System.out.println(te.getContent());
        ct.undo(te);
        System.out.println(te.getContent());
    }
}
