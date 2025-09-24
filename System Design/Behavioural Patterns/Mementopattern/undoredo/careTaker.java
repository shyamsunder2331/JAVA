
import java.util.*;
public class careTaker{
    private static final Stack<editorMemento> history=new Stack<>();

    public static void saveState(TextEditor editor){
        history.push(editor.save());
    }
    public static void undo(TextEditor editor){
        if(!history.isEmpty()){
            history.pop();
            editor.restore(history.peek());
            
        }
    }

}