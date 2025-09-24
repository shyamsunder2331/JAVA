
public class StatePatternWithout {
    public static void main(String[] args) {
        
        DirectionService ds=new DirectionService(TransportationMode.CYCLE);
        
        System.out.println(ds.calculateETA());
        System.out.println(ds.getDirection());

    }

}
