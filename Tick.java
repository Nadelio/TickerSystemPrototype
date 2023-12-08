public class Tick
{
    private int tickID;
    private boolean tickValue;
    
    public Tick(boolean tickValue, int tickID)
    {
        this.tickValue = tickValue;
        this.tickID = tickID;
    }

    public int getTickID(){return tickID;}
    public boolean getTickValue(){return tickValue;}

    public String toString(){return tickID + " " + tickValue;}
}
