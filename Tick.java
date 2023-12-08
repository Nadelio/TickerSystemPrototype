public class Tick
{
    private String tickID;
    private boolean tickValue;
    
    public Tick(boolean tickValue, int tickID)
    {
        this.tickValue = tickValue;
        this.tickID = Integer.toString(tickID);
    }

    public String getTickID(){return tickID;}
    public boolean getTickValue(){return tickValue;}

    public String toString(){return "    " + '"'+ tickID + '"' + " : " + tickValue;}
}
