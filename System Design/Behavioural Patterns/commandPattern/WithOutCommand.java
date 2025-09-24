class TextEditor{
    public void boldText(){
        System.out.println("The text is made Bold");
    }
    public void italicText(){
        System.out.println("The text is made Italic.");
    }
    public void underLine(){
        System.out.println("The text is made underlined");
    }
}
class BoldText{
    private TextEditor editor;
    public BoldText(TextEditor editor){
        this.editor=editor;
    }
    public void click(){
        editor.boldText();
    }
}
class ItalicText{
    private TextEditor editor;
    public ItalicText(TextEditor editor){
        this.editor=editor;
    }
    public void click(){
        editor.italicText();
    }
}
class UnderLine{
    private TextEditor editor;
    public UnderLine(TextEditor editor){
        this.editor=editor;
    }
    public void click(){
        editor.underLine();
    }
}
public class WithOutCommand{
    public static void main(String[] args) {
        TextEditor editor=new TextEditor();
        BoldText bt=new BoldText(editor);
        ItalicText it=new ItalicText(editor);
        bt.click();
        it.click();
        UnderLine ul=new UnderLine(editor);
        ul.click();
    }
}