public class Train implements Transport{
    public int calcETA(){
        System.out.println("The time taking by Train is:");
        return 20;
    }
    public String getDirection(){
            return "By Train you have to go in West direction";
    }
}
