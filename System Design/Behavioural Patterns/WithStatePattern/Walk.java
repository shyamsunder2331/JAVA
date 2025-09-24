public class Walk implements Transport{
    public int calcETA(){
        System.out.println("The time taking by Walk is:");
        return 35;
    }
    public String getDirection(){
            return "By Walk you have to go in North direction";
    }
}