class DirectionService{
    Transport mode;
    public DirectionService(Transport mode){
        this.mode=mode;
    }
    public int calcETA(){
        return mode.calcETA();
    }
    public String getDirection(){
        return mode.getDirection();
    }
}