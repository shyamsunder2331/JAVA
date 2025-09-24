
class DisplayDevice{
    public void showTemp(float temp){
        System.out.println("Current temperatur : "+temp+"'C");
    }
}
class WeatherStation{
    private float temperature;
    private DisplayDevice displayDevice;
    public WeatherStation(DisplayDevice device){
        this.displayDevice=device;
    }
    public void setTemperature(float value){
        this.temperature=value;
        notifyDevice();
    }
    public void notifyDevice(){
        displayDevice.showTemp(temperature);
    }
}
public class WithoutObserverPattern {
    public static void main(String[] args){
        DisplayDevice device=new DisplayDevice();
        WeatherStation ws=new WeatherStation(device);
        ws.setTemperature(26);
        ws.setTemperature(30);
    }
}
