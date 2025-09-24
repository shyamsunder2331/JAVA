import java.util.*;
interface Observer{
    void update(float temp);
}
interface Subject{
    void attach(Observer obs);
    void detach(Observer obs);
    void notifyObservers();
}
//weather station class as publisher
class Weather implements Subject{
    private float temperature=0;
    private List<Observer> observerList;
    public Weather(){
        observerList=new ArrayList<>();
    }
    public void setTemperature(float temp){
        this.temperature=temp;
        notifyObservers();
    }
    public void attach(Observer obs){
        observerList.add(obs);
    }
    public void detach(Observer d){
        observerList.remove(d);
    }
    public void notifyObservers(){
        for(Observer o:observerList){
            o.update(temperature);
        }
    }
}
class DisplayDeviceIn implements Observer{
    public void  update(float temp){
        System.out.println("The Current temperature is "+temp+" 'C");
    }
}
class MobileDeviceIn implements Observer{
    private String name;
    public MobileDeviceIn(String name){
        this.name=name;
    }
    public void update(float temp){
        System.out.println("The current temperature in "+name+" is "+temp+"'C");
    }
}


public class Observer_pattern{
    public static void main(String[] args){
        Weather weather=new Weather();
        DisplayDeviceIn dd=new DisplayDeviceIn();
        MobileDeviceIn mb=new MobileDeviceIn("Apple");
        weather.attach(dd);
        weather.attach(mb);
        weather.setTemperature(26);
        weather.setTemperature(45);
}
}