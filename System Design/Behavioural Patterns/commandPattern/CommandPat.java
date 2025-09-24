

interface Command{
    public void execute();
}

class BoldCommand implements Command{
    private TextEditorII editor;
    public BoldCommand(TextEditorII editor){
        this.editor=editor;
    }
    public void execute(){
        editor.boldText();
    }
}
class Undo implements Command{
    private TextEditorII editor;
    public Undo(TextEditorII editor){
        this.editor=editor;
    }
    public void execute(){
        editor.undo();
    }
}
class Button{
    private Command command;
    public void setCommand(Command command){
        this.command=command;
    }
    public void click(){
        command.execute();
    }
}
class TextEditorII{
    public void boldText(){
        System.out.println("The text has been bolded..");
    }
    public void italicText(){
        System.out.println("The text has been made Italic");
    }
    public void underLine(){
        System.out.println("the Text has been underlined");
    }
    public void undo(){
        System.out.println("The text had been undo");
    }
}
public class CommandPat {
    public static void main(String[] args) {
        TextEditorII te=new TextEditorII();
        Button b=new Button();
        b.setCommand(new BoldCommand(te));
        b.click();
        b.setCommand(new Undo(te));
        b.click();
    }
}
