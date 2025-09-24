import java.util.*;

class ChatUser{
    private String name;
    public ChatUser(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
}
interface ChatInterface{
    public void sendMessage(String msg, ChatUser user);
    public void addUser(ChatUser user);
}
class ChatMediator implements ChatInterface{
    private ArrayList<ChatUser> users=new ArrayList<>();
    
    @Override
    public void sendMessage(String msg,ChatUser user){
        for(ChatUser us:users){
            if(!us.getName().equals(user.getName())){
                System.out.println(user.getName()+" sent message to "+us.getName()+" containing message "+msg);
            }
        }
    }
    @Override
    public void addUser(ChatUser user){
        users.add(user);
    }
}
public class WithMediatorPattern {
     public static void main(String[] args){
        ChatMediator cm=new ChatMediator();

        ChatUser c1=new ChatUser("Shyam");
        ChatUser c2=new ChatUser("ram");
        ChatUser c3=new ChatUser("raju");
        ChatUser c4=new ChatUser("sai");
        
        cm.addUser(c1);
        cm.addUser(c2);
        cm.addUser(c3);
        cm.addUser(c4);

        cm.sendMessage("Hello all, a very good morning.",c1);
        System.out.println();
        cm.sendMessage("Welcome to cogniznat", c4);
    }
}
