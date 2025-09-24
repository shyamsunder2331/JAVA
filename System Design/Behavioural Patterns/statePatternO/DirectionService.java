
enum TransportationMode{
    CAR,CYCLE,TRAIN,WALK
}
public class DirectionService{
    private TransportationMode mode;
    public DirectionService(TransportationMode mode){
        this.mode=mode;
    }
    public void setMode(TransportationMode mode){
        this.mode=mode;
    }
    public int calculateETA(){
        switch(mode){
            case CAR:
                return 10;
            case CYCLE:
                return 25;
            case TRAIN:
                return 20;
            case WALK:
                return 45;
            default:
                throw new IllegalArgumentException("Not a valid modd of transport");
        }
    }
    public String getDirection(){
        switch(mode){
            case CAR:
                return "By car you have to go in EAST direction";
            case CYCLE:
                return "By Cycle you have to go in EAST direction";
            case TRAIN:
                return "By Train you have to go in EAST direction";
            case WALK:
                return "By Walk you have to go in EAST direction";
            default:
                throw new IllegalArgumentException("Not a valid mode of Tranport");
        }
    }
}