interface Transport{
    public void transportService();
}
class Car implements Transport{
    public void transportService(){
        System.out.println("Deilvery by Car");
    }
}
class Bike implements Transport{
    public void transportService(){
        System.out.println("Delivery by Bike");
    }
}
class Bus implements Transport{
    public void transportService(){
        System.out.println("Delivery by bus");
    }
}
public class WithoutFacctoryPattern{
    public static void main(String[] args) {
        Transport car=new Car();
        Transport bus=new Bus();
        Transport bike=new Bike();
        car.transportService();
        bus.transportService();
        bike.transportService();
    }
}