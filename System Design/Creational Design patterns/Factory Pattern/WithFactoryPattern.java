import java.lang.*;

interface InnerWithFactoryPattern {
    public void deliver();
    
}
class Car1 implements InnerWithFactoryPattern{
    public void deliver(){
        System.out.println("Delivery By Car");
    }
}
class Bike1 implements InnerWithFactoryPattern{
    public void deliver(){
        System.out.println("Delivery By Bike");
    }
}
class Bus1 implements InnerWithFactoryPattern{
    public void deliver(){
        System.out.println("Delivery By Bus");
    }
}
class FactoryCreator{
    public static InnerWithFactoryPattern createTransport(String name){
        switch(name.toLowerCase()){
            case "car1":
                return new Car1();
            case "bike1":
                return new Bike1();
            case "bus1":
                return new Bus1();
            default:
                throw new IllegalArgumentException("unsupported transport type");
        }
    }
}
public class WithFactoryPattern{
    public static void main(String[] args) {
        FactoryCreator fc=new FactoryCreator();
        InnerWithFactoryPattern vehicle=fc.createTransport("car1");
        vehicle.deliver();
    }
}