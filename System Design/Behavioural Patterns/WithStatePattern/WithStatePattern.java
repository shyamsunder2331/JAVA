public class WithStatePattern {
    public static void main(String[] args) {
        DirectionService car=new DirectionService(new Car());
        System.out.println(car.calcETA());
        car.getDirection();
        DirectionService walk=new DirectionService(new Walk());
        System.out.println(walk.calcETA());
        walk.getDirection();
        DirectionService train=new DirectionService(new Train());
        System.out.println(train.calcETA());
        train.getDirection();
        
    }
}
