

public class TextEditor{
    private String content;

    public void write(String content){
        this.content=content;
    }
    public String getContent(){
        return this.content;
    }
    public editorMemento save(){
        return new editorMemento(content);
    }
    public void restore(editorMemento memento){
        content=memento.getContent();
    }
}